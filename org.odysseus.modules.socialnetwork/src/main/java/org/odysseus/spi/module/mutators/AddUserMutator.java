package org.odysseus.spi.module.mutators;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.models.socialnetwork.user.Gender;
import org.odysseus.models.socialnetwork.user.Person;
import org.odysseus.models.socialnetwork.user.UserPackage;
import org.odysseus.spi.module.util.NameProvider;

public class AddUserMutator implements Mutator {

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException {
		Person person = context.instantiate(UserPackage.Literals.PERSON);
		Gender gender = context.random().pickOne(Gender.VALUES);
		person.setFirstName(NameProvider.randomFirstName(context.random(), gender));
		person.setLastName(NameProvider.randomLastName(context.random()));
		person.setGender(gender);
		// our users are between 18 and 40 years old
		long fourtyYearsAgo = Instant.now().minus(Duration.ofDays(465 * 40)).toEpochMilli();
		long eighteenYearsAgo = Instant.now().minus(Duration.ofDays(465 * 18)).toEpochMilli();
		// choose it randomly in the given range
		long birthDate = context.random().nextLongBetween(fourtyYearsAgo, eighteenYearsAgo);
		person.setBirthdate(new Date(birthDate));
		// is a member since... now :)
		person.setMemberSince(new Date());
		context.addToModel(person);
	}

	@Override
	public double getBaseLikelyhood() {
		return 1;
	}

	@Override
	public MutatorType getMutatorType() {
		return MutatorType.ADDITION;
	}

	@Override
	public String getName() {
		return "Add User";
	}

}
