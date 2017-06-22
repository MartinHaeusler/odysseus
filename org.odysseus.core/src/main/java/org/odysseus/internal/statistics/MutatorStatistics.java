package org.odysseus.internal.statistics;

import java.util.Map;

import org.odysseus.spi.Mutator;

public interface MutatorStatistics {

	public void mutatorAttempt(Mutator mutator);

	public void mutatorSuccessful(Mutator mutator);

	public Map<Mutator, Integer> getAttempts();

	public Map<Mutator, Integer> getSuccessfulRuns();

	public int getAttempts(Mutator mutator);

	public int getSuccessfulRuns(Mutator mutator);

	public Map<Mutator, Integer> getFailedAttempts();

	public int getFailedAttempts(Mutator mutator);

}
