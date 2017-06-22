package org.odysseus.api;

import java.util.List;

import org.odysseus.internal.mutatorselector.BaseLikelyhoodSelector;
import org.odysseus.internal.mutatorselector.EqualChanceMutatorSelector;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;

public interface MutatorSelector {

	// =================================================================================================================
	// STATIC FACTORY METHODS
	// =================================================================================================================

	public static EqualChanceMutatorSelector equalChances() {
		return new EqualChanceMutatorSelector();
	}

	public static BaseLikelyhoodSelector baseLikelyhood() {
		return new BaseLikelyhoodSelector();
	}

	// =================================================================================================================
	// PUBLIC API
	// =================================================================================================================

	public Mutator selectNextMutator(ModelGenerationContext context, List<Mutator> availableMutators);

}
