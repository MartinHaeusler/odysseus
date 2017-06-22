package org.odysseus.internal.mutatorselector;

import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;

public class BaseLikelyhoodSelector extends LikelyhoodSelector<BaseLikelyhoodSelector> {

	@Override
	protected double getLikelyhood(final ModelGenerationContext context, final Mutator mutator) {
		return mutator.getBaseLikelyhood();
	}

}
