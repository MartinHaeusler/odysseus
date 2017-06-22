package org.odysseus.spi.module.mutators;

import java.util.List;
import java.util.Map;

import org.odysseus.models.socialnetwork.user.Person;
import org.odysseus.models.socialnetwork.user.UserPackage;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;

public class AddFriendMutator implements Mutator {

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException {
		List<Person> persons = context.getAnyDistinctInstancesOf(UserPackage.Literals.PERSON, 100);
		Person p1 = persons.remove(0);
		for (Person p2 : persons) {
			if (p1.getFriends().contains(p2) == false) {
				// turn these two into friends
				p1.getFriends().add(p2);
				p2.getFriends().add(p1);
				return;
			}
		}
		throw new ModificationNotApplicableException("No non-friend Person found.");
	}

	@Override
	public double getBaseLikelyhood() {
		return 1;
	}

	@Override
	public MutatorType getMutatorType() {
		return MutatorType.VARIATION;
	}

	@Override
	public String getName() {
		return "Add Friend";
	}

}
