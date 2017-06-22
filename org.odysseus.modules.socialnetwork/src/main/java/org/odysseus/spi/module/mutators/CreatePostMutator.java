package org.odysseus.spi.module.mutators;

import java.util.Date;
import java.util.Map;

import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.spi.exceptions.NotEnoughElementsException;
import org.odysseus.models.socialnetwork.activity.ActivityPackage;
import org.odysseus.models.socialnetwork.activity.Post;
import org.odysseus.models.socialnetwork.activity.Visibility;
import org.odysseus.models.socialnetwork.media.MediaData;
import org.odysseus.models.socialnetwork.media.MediaPackage;
import org.odysseus.models.socialnetwork.user.Group;
import org.odysseus.models.socialnetwork.user.Person;
import org.odysseus.models.socialnetwork.user.UserPackage;

public class CreatePostMutator implements Mutator {

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException {
		// choose the person who should create the post
		Person person = context.getAnyInstanceOf(UserPackage.Literals.PERSON);
		Post post = context.instantiate(ActivityPackage.Literals.POST);
		// set the person we just picked to be the author
		post.setAuthor(person);
		// set the creation date to "now"
		post.setDate(new Date());
		// use some sample text
		post.setText("Lorem ipsum dolor sit amet");
		// pick a random visibility
		post.setVisibility(context.random().pickOne(Visibility.VALUES));
		// toss a coin to see if we add some media data
		if (context.random().coinToss()) {
			// add media data (if we have any)
			try {
				MediaData mediaData = context.getAnyInstanceOf(MediaPackage.Literals.MEDIA_DATA);
				if (mediaData != null) {
					post.getAttachedMedia().add(mediaData);
				}
				// we could add more media data here...
			} catch (NotEnoughElementsException ignored) {
				// we did not have any media data to attach.
			}
		}
		// check if we can post it in a group, and if so toss a coin if we want to
		if (person.getMembershipInGroups().isEmpty() == false && context.random().coinToss()) {
			// post it in a group
			Group group = context.random().pickOne(person.getMembershipInGroups());
			post.setInGroup(group);
		}
		context.addToModel(post);
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
		return "Create Post";
	}

}
