package org.odysseus.spi.module.mutators;

import java.util.Date;
import java.util.Map;

import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;
import org.odysseus.spi.ProbabilityDistribution;
import org.odysseus.spi.RandomGenerator;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.models.socialnetwork.media.MediaData;
import org.odysseus.models.socialnetwork.media.MediaPackage;
import org.odysseus.models.socialnetwork.media.MediaType;

public class UploadMediaFileMutator implements Mutator {

	@Override
	public void apply(final ModelGenerationContext context, final Map<String, Object> state)
			throws ModificationNotApplicableException {
		MediaData mediaData = context.instantiate(MediaPackage.Literals.MEDIA_DATA);
		// pick a random media type from a weighted distribution
		mediaData.setType(this.chooseMediaType(context.random()));
		// give it a random name
		mediaData.setName("File_" + context.random().nextLongBetween(0, Long.MAX_VALUE));

		// we skip the content for now
		// mediaData.setContent(value);

		// upload date is now
		mediaData.setUploadDate(new Date());
		context.addToModel(mediaData);
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
		return "Upload Media File";
	}

	// =================================================================================================================
	// HELPER METHODS
	// =================================================================================================================

	private MediaType chooseMediaType(final RandomGenerator random) {
		ProbabilityDistribution<MediaType> pd = ProbabilityDistribution.<MediaType>discrete(random)
				//
				.event(MediaType.IMAGE, 10)
				//
				.event(MediaType.VIDEO, 4)
				//
				.event(MediaType.AUDIO, 1)
				//
				.build();
		// pick one
		MediaType mediaType = pd.nextEvent();
		return mediaType;
	}

}
