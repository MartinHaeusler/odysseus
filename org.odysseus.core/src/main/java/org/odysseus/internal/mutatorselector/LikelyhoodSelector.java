package org.odysseus.internal.mutatorselector;

import static com.google.common.base.Preconditions.*;

import java.util.List;
import java.util.Map;

import org.odysseus.api.MutatorSelector;
import org.odysseus.spi.DiscreteProbabilityDistributionBuilder;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.ProbabilityDistribution;

import com.google.common.collect.Maps;

public abstract class LikelyhoodSelector<SELF extends MutatorSelector> implements MutatorSelector {

	protected final Map<Class<? extends Mutator>, Double> likelyhoodOverrides = Maps.newHashMap();

	@Override
	public Mutator selectNextMutator(final ModelGenerationContext context, final List<Mutator> availableMutators) {
		DiscreteProbabilityDistributionBuilder<Mutator> builder = ProbabilityDistribution.discrete(context.random());
		for (Mutator mutator : availableMutators) {
			final double likelyhood;
			Double likelyhoodOverride = this.likelyhoodOverrides.get(mutator.getClass());
			if (likelyhoodOverride != null) {
				likelyhood = likelyhoodOverride;
			} else {
				likelyhood = this.getLikelyhood(context, mutator);
			}
			builder.event(mutator, likelyhood);
		}
		ProbabilityDistribution<Mutator> mutatorDistribution = builder.build();
		return mutatorDistribution.nextEvent();
	}

	protected abstract double getLikelyhood(ModelGenerationContext context, Mutator mutator);

	@SuppressWarnings("unchecked")
	public SELF likelyhood(final Class<? extends Mutator> mutatorClass, final double likelyhood) {
		checkNotNull(mutatorClass, "Precondition violation - argument 'mutatorClass' must not be NULL!");
		checkArgument(likelyhood >= 0, "Precondition violation - argument 'likelyhood' must not be negative!");
		this.likelyhoodOverrides.put(mutatorClass, likelyhood);
		return (SELF) this;
	}
}
