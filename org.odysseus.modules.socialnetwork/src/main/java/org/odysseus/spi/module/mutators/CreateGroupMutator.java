package org.odysseus.spi.module.mutators;

import java.util.Date;
import java.util.Map;

import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.models.socialnetwork.user.Group;
import org.odysseus.models.socialnetwork.user.Person;
import org.odysseus.models.socialnetwork.user.UserPackage;
import org.odysseus.spi.module.util.NameProvider;

public class CreateGroupMutator implements Mutator {

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException {
		Person person = context.getAnyInstanceOf(UserPackage.Literals.PERSON);
		Group group = context.instantiate(UserPackage.Literals.GROUP);
		group.setName(NameProvider.randomGroupName(context.random()));
		group.setAdmin(person);
		group.setCreationDate(new Date());
		context.addToModel(group);
	}

	@Override
	public double getBaseLikelyhood() {
		return 0.6;
	}

	@Override
	public MutatorType getMutatorType() {
		return MutatorType.ADDITION;
	}

	@Override
	public String getName() {
		return "Create Group";
	}

}
