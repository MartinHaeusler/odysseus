package org.odysseus.spi.module.mutators;

import java.util.Date;
import java.util.Map;

import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.models.socialnetwork.activity.ActivityPackage;
import org.odysseus.models.socialnetwork.activity.Post;
import org.odysseus.models.socialnetwork.activity.Reaction;
import org.odysseus.models.socialnetwork.activity.ReactionType;
import org.odysseus.models.socialnetwork.user.Person;
import org.odysseus.models.socialnetwork.user.UserPackage;

public class AddReactionToPostMutator implements Mutator {

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException {
		Person person = context.getAnyInstanceOf(UserPackage.Literals.PERSON);
		Post post = context.getAnyInstanceOf(ActivityPackage.Literals.POST);
		if (post.getReactions().stream().anyMatch(reaction -> reaction.getAuthor().equals(person))) {
			throw new ModificationNotApplicableException("Person already reacted to this Post.");
		}
		Reaction reaction = context.instantiate(ActivityPackage.Literals.REACTION);
		reaction.setAuthor(person);
		reaction.setPost(post);
		reaction.setDate(new Date());
		reaction.setType(context.random().pickOne(ReactionType.VALUES));
		context.addToModel(reaction);
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
		return "Add Reaction";
	}

}
