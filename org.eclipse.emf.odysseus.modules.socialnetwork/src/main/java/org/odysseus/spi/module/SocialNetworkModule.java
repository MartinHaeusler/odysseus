package org.odysseus.spi.module;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.odysseus.models.socialnetwork.activity.ActivityPackage;
import org.odysseus.models.socialnetwork.media.MediaPackage;
import org.odysseus.models.socialnetwork.user.UserPackage;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.OdysseusModule;
import org.odysseus.spi.module.mutators.AddCommentToPostMutator;
import org.odysseus.spi.module.mutators.AddFriendMutator;
import org.odysseus.spi.module.mutators.AddReactionToPostMutator;
import org.odysseus.spi.module.mutators.AddUserMutator;
import org.odysseus.spi.module.mutators.ChildBirthMutator;
import org.odysseus.spi.module.mutators.CreateGroupMutator;
import org.odysseus.spi.module.mutators.CreatePostMutator;
import org.odysseus.spi.module.mutators.JoinGroupMutator;
import org.odysseus.spi.module.mutators.MarriageMutator;
import org.odysseus.spi.module.mutators.SharePostMutator;

import com.google.common.collect.Lists;

public class SocialNetworkModule implements OdysseusModule {

	private final List<Mutator> mutators = Collections.unmodifiableList(Lists.newArrayList(
			//
			new AddCommentToPostMutator(),
			//
			new AddFriendMutator(),
			//
			new AddReactionToPostMutator(),
			//
			new AddUserMutator(),
			//
			new ChildBirthMutator(),
			//
			new CreateGroupMutator(),
			//
			new CreatePostMutator(),
			//
			new JoinGroupMutator(),
			//
			new MarriageMutator(),
			//
			new SharePostMutator()));

	@Override
	public Collection<? extends EPackage> getEPackages() {
		List<EPackage> ePackages = Lists.newArrayList();
		ePackages.add(UserPackage.eINSTANCE);
		ePackages.add(MediaPackage.eINSTANCE);
		ePackages.add(ActivityPackage.eINSTANCE);
		return ePackages;
	}

	@Override
	public Collection<? extends Mutator> getMutators() {
		return this.mutators;
	}

	@Override
	public String getSimpleName() {
		return "Social Network";
	}

	@Override
	public String getQualifiedName() {
		return "org.odysseus.models.socialnetwork";
	}

	@Override
	public String getVendor() {
		return "Martin Haeusler (martin.haeusler@uibk.ac.at)";
	}

	@Override
	public String getVersion() {
		return "0.0.1";
	}

}
