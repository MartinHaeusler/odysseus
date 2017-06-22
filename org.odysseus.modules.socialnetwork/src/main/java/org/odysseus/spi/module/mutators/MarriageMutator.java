package org.odysseus.spi.module.mutators;

import static com.google.common.base.Preconditions.*;

import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.models.socialnetwork.user.Gender;
import org.odysseus.models.socialnetwork.user.Person;
import org.odysseus.models.socialnetwork.user.UserPackage;

public class MarriageMutator implements Mutator {

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException {
		List<Person> candidates = context.getAnyDistinctInstancesOf(UserPackage.Literals.PERSON, 100);
		List<Person> singleMales = candidates.stream()
				.filter(p -> p.getMarriedTo() == null && p.getGender().equals(Gender.MALE))
				.filter(p -> this.ageInYears(p) >= 18).collect(Collectors.toList());
		List<Person> singleFemales = candidates.stream()
				.filter(p -> p.getMarriedTo() == null && p.getGender().equals(Gender.FEMALE))
				.filter(p -> this.ageInYears(p) >= 18).collect(Collectors.toList());
		if (singleMales.isEmpty() || singleFemales.isEmpty()) {
			throw new ModificationNotApplicableException("Not enough marriage candidates.");
		}
		Person groom = context.random().pickOne(singleMales);
		Person bride = context.random().pickOne(singleFemales);
		// marry them
		groom.setMarriedTo(bride);
		bride.setMarriedTo(groom);
		// decide what to do about their last names.
		// First, check if any one of them has a double name.
		if (this.isDoubleName(groom.getLastName()) || this.isDoubleName(bride.getLastName())) {
			int random = context.random().nextIntBetween(0, 100);
			if (random < 33) {
				// use the groom's last name for the bride
				bride.setLastName(groom.getLastName());
			} else if (random < 66) {
				// use the bride's last name for the groom
				groom.setLastName(bride.getLastName());
			} else {
				// they keep their original names
			}
		} else {
			int random = context.random().nextIntBetween(0, 100);
			if (random < 25) {
				// use the groom's last name for the bride
				bride.setLastName(groom.getLastName());
			} else if (random < 50) {
				// use the bride's last name for the groom
				groom.setLastName(bride.getLastName());
			} else if (random < 75) {
				// both use a double-name
				String doubleName = null;
				// do a coin toss which name will be first and which one second
				if (context.random().coinToss()) {
					doubleName = this.doubleName(groom.getLastName(), bride.getLastName());
				} else {
					doubleName = this.doubleName(bride.getLastName(), groom.getLastName());
				}
				// assign the names
				groom.setLastName(doubleName);
				bride.setLastName(doubleName);
			} else {
				// they keep their original names
			}
		}
	}

	@Override
	public double getBaseLikelyhood() {
		return 0.1;
	}

	@Override
	public MutatorType getMutatorType() {
		return MutatorType.VARIATION;
	}

	@Override
	public String getName() {
		return "Marriage";
	}

	// =================================================================================================================
	// HELPER METHODS
	// =================================================================================================================

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

	protected int ageInYears(final Person person) {
		Date birthdate = person.getBirthdate();
		return Period.between(birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).getYears();
	}
}
