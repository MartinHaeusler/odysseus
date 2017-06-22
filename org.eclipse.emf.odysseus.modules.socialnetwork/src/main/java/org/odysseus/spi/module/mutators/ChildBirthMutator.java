package org.odysseus.spi.module.mutators;

import static com.google.common.base.Preconditions.*;

import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.models.socialnetwork.user.Gender;
import org.odysseus.models.socialnetwork.user.Person;
import org.odysseus.models.socialnetwork.user.UserPackage;
import org.odysseus.spi.module.util.NameProvider;

import com.google.common.collect.Sets;

public class ChildBirthMutator implements Mutator {

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException {
		List<Person> persons = context.getAnyDistinctInstancesOf(UserPackage.Literals.PERSON, 300);
		List<Person> males = persons.stream().filter(p -> p.getGender().equals(Gender.MALE))
				.filter(p -> this.ageInYears(p) >= 18).collect(Collectors.toList());
		List<Person> females = persons.stream().filter(p -> p.getGender().equals(Gender.FEMALE))
				.filter(p -> this.ageInYears(p) >= 18).collect(Collectors.toList());
		if (males.isEmpty() || females.isEmpty()) {
			throw new ModificationNotApplicableException("Not enough Persons for children.");
		}
		for (Person male : males) {
			if (male.getMarriedTo() != null) {
				// person is married, high chance of child with partner
				if (context.random().nextIntBetween(0, 100) < 95) {
					Person female = male.getMarriedTo();
					Person child = this.child(context, male, female);
					context.addToModel(child);
					return;
				}
			}
			// find a suitable female
			for (Person female : females) {
				if (this.isAncestor(male, female) || this.isAncestor(female, male)) {
					// no children between ancestors
					continue;
				}
				if (this.isSibling(male, female)) {
					// no children between siblings
					continue;
				}
				Person child = this.child(context, male, female);
				context.addToModel(child);
				return;
			}
		}
		throw new ModificationNotApplicableException("No suitable pair of parents found.");
	}

	@Override
	public double getBaseLikelyhood() {
		return 0.3;
	}

	@Override
	public MutatorType getMutatorType() {
		return MutatorType.ADDITION;
	}

	@Override
	public String getName() {
		return "Child Birth";
	}

	protected boolean isAncestor(final Person p, final Person ancestor) {
		Set<Person> toCheck = Sets.newHashSet();
		toCheck.add(p);
		boolean changed = true;
		while (changed) {
			changed = false;
			if (toCheck.contains(ancestor)) {
				return true;
			}
			Set<Person> toAdd = Sets.newHashSet();
			for (Person person : toCheck) {
				toAdd.addAll(person.getParents());
			}
			changed = toCheck.addAll(toAdd);
		}
		return false;
	}

	protected boolean isSibling(final Person a, final Person b) {
		for (Person parent : a.getParents()) {
			if (b.getParents().contains(parent)) {
				return true;
			}
		}
		return false;
	}

	protected int ageInYears(final Person person) {
		Date birthdate = person.getBirthdate();
		return Period.between(birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).getYears();
	}

	protected Person child(final ModelGenerationContext context, final Person father, final Person mother) {
		Person child = context.instantiate(UserPackage.Literals.PERSON);
		child.getParents().add(father);
		child.getParents().add(mother);
		Gender gender = context.random().pickOne(Gender.VALUES);
		child.setGender(gender);
		child.setFirstName(NameProvider.randomFirstName(context.random(), gender));
		// choose what happens about the last name
		String lastName = null;
		if (father.getLastName().equals(mother.getLastName())) {
			lastName = father.getLastName();
		} else {
			if (this.isDoubleName(father.getLastName()) || this.isDoubleName(mother.getLastName())) {
				// choose one of the two
				if (context.random().coinToss()) {
					lastName = father.getLastName();
				} else {
					lastName = mother.getLastName();
				}
			} else {
				// choose father's last name, mother's last name, or a double name
				int random = context.random().nextIntBetween(0, 100);
				if (random < 33) {
					lastName = father.getLastName();
				} else if (random < 66) {
					lastName = mother.getLastName();
				} else {
					lastName = this.doubleName(father.getLastName(), mother.getLastName());
				}
			}
		}
		child.setLastName(lastName);
		child.setBirthdate(new Date());
		child.setMemberSince(new Date());
		return child;
	}

	protected boolean isDoubleName(final String lastName) {
		checkNotNull(lastName, "Precondition violation - argument 'lastName' must not be NULL!");
		if (lastName.contains("-")) {
			return true;
		} else {
			return false;
		}
	}

	protected String doubleName(final String lastName1, final String lastName2) {
		checkNotNull(lastName1, "Precondition violation - argument 'lastName1' must not be NULL!");
		checkNotNull(lastName2, "Precondition violation - argument 'lastName2' must not be NULL!");
		return lastName1 + "-" + lastName2;
	}
}
