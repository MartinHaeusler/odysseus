package org.odysseus.internal.statistics;

import static com.google.common.base.Preconditions.*;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import org.odysseus.spi.Mutator;

import com.google.common.collect.Maps;

public class MutatorStatisticsImpl implements MutatorStatistics {

	private final Map<Mutator, Integer> attempts;
	private final Map<Mutator, Integer> successfulRuns;

	public MutatorStatisticsImpl() {
		this.attempts = Maps.newHashMap();
		this.successfulRuns = Maps.newHashMap();
	}

	@Override
	public void mutatorAttempt(final Mutator mutator) {
		checkNotNull(mutator, "Precondition violation - argument 'mutator' must not be NULL!");
		Integer integer = this.attempts.get(mutator);
		if (integer == null) {
			integer = 0;
		}
		this.attempts.put(mutator, integer + 1);
	}

	@Override
	public void mutatorSuccessful(final Mutator mutator) {
		checkNotNull(mutator, "Precondition violation - argument 'mutator' must not be NULL!");
		Integer integer = this.successfulRuns.get(mutator);
		if (integer == null) {
			integer = 0;
		}
		this.successfulRuns.put(mutator, integer + 1);

	}

	@Override
	public Map<Mutator, Integer> getAttempts() {
		return Collections.unmodifiableMap(this.attempts);
	}

	@Override
	public Map<Mutator, Integer> getSuccessfulRuns() {
		return Collections.unmodifiableMap(this.successfulRuns);
	}

	@Override
	public int getAttempts(final Mutator mutator) {
		checkNotNull(mutator, "Precondition violation - argument 'mutator' must not be NULL!");
		Integer attempts = this.attempts.get(mutator);
		if (attempts == null) {
			return 0;
		} else {
			return attempts;
		}
	}

	@Override
	public int getSuccessfulRuns(final Mutator mutator) {
		checkNotNull(mutator, "Precondition violation - argument 'mutator' must not be NULL!");
		Integer attempts = this.successfulRuns.get(mutator);
		if (attempts == null) {
			return 0;
		} else {
			return attempts;
		}
	}

	@Override
	public Map<Mutator, Integer> getFailedAttempts() {
		Map<Mutator, Integer> attempts = Maps.newHashMap(this.attempts);
		for (Entry<Mutator, Integer> successEntry : this.successfulRuns.entrySet()) {
			Mutator mutator = successEntry.getKey();
			Integer successfulRuns = successEntry.getValue();
			if (successfulRuns == null) {
				successfulRuns = 0;
			}
			Integer attemptCount = attempts.get(mutator);
			if (attemptCount == null) {
				attemptCount = 0;
			}
			attempts.put(mutator, attemptCount - successfulRuns);
		}
		return Collections.unmodifiableMap(attempts);
	}

	@Override
	public int getFailedAttempts(final Mutator mutator) {
		checkNotNull(mutator, "Precondition violation - argument 'mutator' must not be NULL!");
		int successfulRuns = this.getSuccessfulRuns(mutator);
		int attempts = this.getAttempts(mutator);
		return attempts - successfulRuns;
	}

}
