package org.odysseus.spi.module.mutators;

import java.util.Date;
import java.util.Map;

import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.models.socialnetwork.activity.ActivityPackage;
import org.odysseus.models.socialnetwork.activity.Post;
import org.odysseus.models.socialnetwork.activity.Visibility;
import org.odysseus.models.socialnetwork.user.Group;
import org.odysseus.models.socialnetwork.user.Person;
import org.odysseus.models.socialnetwork.user.UserPackage;

public class SharePostMutator implements Mutator {

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException {
		Post post = context.getAnyInstanceOf(ActivityPackage.Literals.POST);
		Person person = context.getAnyInstanceOf(UserPackage.Literals.PERSON);
		// create the re-post
		Post repost = context.instantiate(ActivityPackage.Literals.POST);
		repost.setIsRepostOf(post);
		repost.setAuthor(person);
		// use some sample text
		repost.setText("Lorem ipsum dolor sit amet");
		repost.setVisibility(context.random().pickOne(Visibility.VALUES));
		repost.setDate(new Date());
		// let the person share the post, either in a group or globally
		if (context.random().coinToss() || person.getMembershipInGroups().isEmpty()) {
			// share globally
			repost.setInGroup(null);
		} else {
			// share in a group
			Group group = context.random().pickOne(person.getMembershipInGroups());
			repost.setInGroup(group);
		}
		context.addToModel(repost);
	}

	@Override
	public double getBaseLikelyhood() {
		return 0.75;
	}

	@Override
	public MutatorType getMutatorType() {
		return MutatorType.ADDITION;
	}

	@Override
	public String getName() {
		return "Share Post";
	}

}
