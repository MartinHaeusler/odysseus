package org.odysseus.internal.mutatorselector;

import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;

public class EqualChanceMutatorSelector extends LikelyhoodSelector<EqualChanceMutatorSelector> {

	@Override
	protected double getLikelyhood(final ModelGenerationContext context, final Mutator mutator) {
		// we assign an equal likelyhood to all mutators
		return 1;
	}

}
