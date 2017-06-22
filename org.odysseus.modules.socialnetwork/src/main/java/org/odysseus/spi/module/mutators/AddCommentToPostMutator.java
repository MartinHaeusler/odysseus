package org.odysseus.spi.module.mutators;

import java.util.Date;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.odysseus.models.socialnetwork.activity.ActivityPackage;
import org.odysseus.models.socialnetwork.activity.Comment;
import org.odysseus.models.socialnetwork.activity.Post;
import org.odysseus.models.socialnetwork.user.Person;
import org.odysseus.models.socialnetwork.user.UserPackage;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;

public class AddCommentToPostMutator implements Mutator {

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException {
		EClass ecPerson = UserPackage.Literals.PERSON;
		EClass ecPost = ActivityPackage.Literals.POST;
		Person person = context.getAnyInstanceOf(ecPerson);
		Post post = context.getAnyInstanceOf(ecPost);
		Comment comment = context.instantiate(ActivityPackage.Literals.COMMENT);
		Comment inResponseTo = null;
		if (context.random().coinToss() && post.getComments().isEmpty() == false) {
			inResponseTo = context.random().pickOne(post.getComments());
		}
		comment.setInResponseTo(inResponseTo);
		comment.setAuthor(person);
		comment.setPost(post);
		comment.setText("Yeah!");
		comment.setDate(new Date());
		context.addToModel(comment);
	}

	@Override
	public double getBaseLikelyhood() {
		return 0.9;
	}

	@Override
	public MutatorType getMutatorType() {
		return MutatorType.ADDITION;
	}

	@Override
	public String getName() {
		return "Add Comment";
	}

}
