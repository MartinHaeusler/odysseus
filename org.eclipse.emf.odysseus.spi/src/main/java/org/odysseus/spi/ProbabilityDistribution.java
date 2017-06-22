package org.odysseus.spi;

public interface ProbabilityDistribution<E> {

	public static <E> DiscreteProbabilityDistributionBuilder<E> discrete(final RandomGenerator random) {
		return DiscreteProbabilityDistribution.<E>builder(random);
	}

	public E nextEvent();

}
