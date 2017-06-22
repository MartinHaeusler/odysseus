package org.odysseus.spi.module.mutators;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.models.socialnetwork.user.Group;
import org.odysseus.models.socialnetwork.user.Person;
import org.odysseus.models.socialnetwork.user.UserPackage;

public class JoinGroupMutator implements Mutator {

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException {
		EClass ecPerson = UserPackage.Literals.PERSON;
		EClass ecGroup = UserPackage.Literals.GROUP;
		Person person = context.getAnyInstanceOf(ecPerson);
		Group group = context.getAnyInstanceOf(ecGroup);
		if (person.getMembershipInGroups().contains(group)) {
			throw new ModificationNotApplicableException("Person is already a member of the chosen group.");
		}
		person.getMembershipInGroups().add(group);
	}

	@Override
	public double getBaseLikelyhood() {
		return 0.7;
	}

	@Override
	public MutatorType getMutatorType() {
		return MutatorType.VARIATION;
	}

	@Override
	public String getName() {
		return "Join Group";
	}

}
