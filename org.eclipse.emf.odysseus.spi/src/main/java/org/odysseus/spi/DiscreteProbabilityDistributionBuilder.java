package org.odysseus.spi;

import static com.google.common.base.Preconditions.*;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

public class DiscreteProbabilityDistributionBuilder<E> {

	private final Map<E, Double> eventToWeight;
	private RandomGenerator random = null;

	/* default */ DiscreteProbabilityDistributionBuilder(final RandomGenerator random) {
		checkNotNull(random, "Precondition violation - argument 'random' must not be NULL!");
		this.eventToWeight = Maps.newHashMap();
		this.random = random;
	}

	public DiscreteProbabilityDistributionBuilder<E> event(final E event, final double weight) {
		checkNotNull(event, "Precondition violation - argument 'event' must not be NULL!");
		checkArgument(weight >= 0, "Precondition violation - argument 'weight' must not be negative!");
		this.eventToWeight.put(event, weight);
		return this;
	}

	public DiscreteProbabilityDistribution<E> build() {
		Map<E, Double> normalizedDistribution = this.normalize();
		RandomGenerator random = this.random;
		return new DiscreteProbabilityDistribution<E>(normalizedDistribution, random);
	}

	private Map<E, Double> normalize() {
		Map<E, Double> resultMap = Maps.newHashMap();
		// first of all, eliminate all events with a weight of zero or less while
		// calculating the sum of the weights as a side-effect
		double sumOfWeights = 0;
		for (Entry<E, Double> entry : this.eventToWeight.entrySet()) {
			E event = entry.getKey();
			Double weight = entry.getValue();
			if (weight != null && weight > 0) {
				resultMap.put(event, weight);
				sumOfWeights += weight;
			}
		}
		// ... declare a final sum variable for usage in lamda expression
		final double sum = sumOfWeights;
		// then, normalize the values by dividing each weight by the sum of weights
		resultMap.replaceAll((event, weight) -> weight / sum);
		return resultMap;
	}

}
