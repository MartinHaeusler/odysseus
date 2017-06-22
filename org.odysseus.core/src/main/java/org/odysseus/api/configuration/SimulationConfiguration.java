package org.odysseus.api.configuration;

import java.util.Set;
import java.util.function.Predicate;

import org.eclipse.emf.ecore.EClass;
import org.odysseus.api.MutatorSelector;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;

public interface SimulationConfiguration extends PartialOdysseusConfiguration {

	// =================================================================================================================
	// STOP CRITERION
	// =================================================================================================================

	public Predicate<ModelGenerationContext> getStopCriterion();

	public void setStopCriterion(Predicate<ModelGenerationContext> criterion);

	public void stopAfterIterions(int iterations);

	public void stopAfterModelSizeReached(EClass eClass, int minimumNumberOfInstances, boolean includeSubclasses);

	// =================================================================================================================
	// MUTATORS
	// =================================================================================================================

	public void setExcludedMutators(Iterable<? extends Class<? extends Mutator>> mutatorClasses);

	public void excludeMutator(Class<? extends Mutator> mutatorClass);

	public Set<Class<? extends Mutator>> getExcludedMutators();

	public void setExcludedMutatorTypes(Iterable<? extends MutatorType> mutatorTypes);

	public void excludeMutatorType(MutatorType mutatorType);

	public Set<? extends MutatorType> getExcludedMutatorTypes();

	public boolean isMutatorExcluded(Mutator mutator);

	// =================================================================================================================
	// MUTATOR SELECTOR
	// =================================================================================================================

	public void setMutatorSelector(MutatorSelector selector);

	public MutatorSelector getMutatorSelector();

	// =================================================================================================================
	// FLUSH INTERVAL
	// =================================================================================================================

	public int getFlushInterval();

	public void setFlushInterval(int interval);

}
