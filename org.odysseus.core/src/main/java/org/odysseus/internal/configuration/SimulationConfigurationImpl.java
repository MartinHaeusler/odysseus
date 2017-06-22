package org.odysseus.internal.configuration;

import static com.google.common.base.Preconditions.*;

import java.util.Collections;
import java.util.Set;
import java.util.function.Predicate;

import org.eclipse.emf.ecore.EClass;
import org.odysseus.api.MutatorSelector;
import org.odysseus.api.configuration.SimulationConfiguration;
import org.odysseus.exceptions.OdysseusConfigurationException;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.MutatorType;

import com.google.common.collect.Sets;

public class SimulationConfigurationImpl implements SimulationConfiguration {

	// =================================================================================================================
	// FIELDS
	// =================================================================================================================

	protected Predicate<ModelGenerationContext> stopCriterion;
	protected final Set<Class<? extends Mutator>> excludedMutators;
	protected final Set<MutatorType> excludedMutatorTypes;
	protected MutatorSelector mutatorSelector;
	protected int flushInterval;

	// =================================================================================================================
	// CONSTRUCTOR
	// =================================================================================================================

	public SimulationConfigurationImpl() {
		this.excludedMutators = Sets.newHashSet();
		this.excludedMutatorTypes = Sets.newHashSet();
		this.flushInterval = 1;
	}

	// =================================================================================================================
	// PUBLIC API [CONFIGURATION]
	// =================================================================================================================

	@Override
	public Predicate<ModelGenerationContext> getStopCriterion() {
		return this.stopCriterion;
	}

	@Override
	public void setStopCriterion(final Predicate<ModelGenerationContext> criterion) {
		checkNotNull(criterion, "Precondition violation - argument 'criterion' must not be NULL!");
		this.stopCriterion = criterion;
	}

	@Override
	public void stopAfterIterions(final int iterations) {
		checkArgument(iterations > 0, "Precondition violation - argument 'iterations' must be greater than zero!");
		this.stopCriterion = (context) -> context.getIteration() >= iterations;
	}

	@Override
	public void stopAfterModelSizeReached(final EClass eClass, final int minimumNumberOfInstances,
			final boolean includeSubclasses) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		checkArgument(minimumNumberOfInstances > 0,
				"Precondition violation - argument 'minimumNumberOfInstances' must be greater than zero!");
		this.stopCriterion = (context) -> {
			return context.countInstancesOf(eClass, includeSubclasses) >= minimumNumberOfInstances;
		};
	}

	// =================================================================================================================
	// MUTATORS
	// =================================================================================================================

	@Override
	public void setExcludedMutators(final Iterable<? extends Class<? extends Mutator>> mutatorClasses) {
		checkNotNull(mutatorClasses, "Precondition violation - argument 'mutatorClasses' must not be NULL!");
		this.excludedMutators.clear();
		for (Class<? extends Mutator> mutatorClass : mutatorClasses) {
			this.excludeMutator(mutatorClass);
		}
	}

	@Override
	public void excludeMutator(final Class<? extends Mutator> mutatorClass) {
		checkNotNull(mutatorClass, "Precondition violation - argument 'mutatorClass' must not be NULL!");
		this.excludedMutators.add(mutatorClass);
	}

	@Override
	public Set<Class<? extends Mutator>> getExcludedMutators() {
		return Collections.unmodifiableSet(this.excludedMutators);
	}

	@Override
	public void setExcludedMutatorTypes(final Iterable<? extends MutatorType> mutatorTypes) {
		checkNotNull(mutatorTypes, "Precondition violation - argument 'mutatorTypes' must not be NULL!");
		this.excludedMutatorTypes.clear();
		for (MutatorType mutatorType : mutatorTypes) {
			this.excludeMutatorType(mutatorType);
		}
	}

	@Override
	public void excludeMutatorType(final MutatorType mutatorType) {
		checkNotNull(mutatorType, "Precondition violation - argument 'mutatorType' must not be NULL!");
		this.excludedMutatorTypes.add(mutatorType);
	}

	@Override
	public Set<? extends MutatorType> getExcludedMutatorTypes() {
		return Collections.unmodifiableSet(this.excludedMutatorTypes);
	}

	@Override
	public boolean isMutatorExcluded(final Mutator mutator) {
		checkNotNull(mutator, "Precondition violation - argument 'mutator' must not be NULL!");
		if (this.excludedMutators.contains(mutator.getClass())) {
			return true;
		} else if (this.excludedMutatorTypes.contains(mutator.getMutatorType())) {
			return true;
		}
		return false;
	}

	// =================================================================================================================
	// MUTATOR SELECTION
	// =================================================================================================================

	@Override
	public void setMutatorSelector(final MutatorSelector selector) {
		checkNotNull(selector, "Precondition violation - argument 'selector' must not be NULL!");
		this.mutatorSelector = selector;
	}

	@Override
	public MutatorSelector getMutatorSelector() {
		return this.mutatorSelector;
	}

	// =================================================================================================================
	// FLUSH INTERVAL
	// =================================================================================================================

	@Override
	public int getFlushInterval() {
		return this.flushInterval;
	}

	@Override
	public void setFlushInterval(final int interval) {
		this.flushInterval = interval;
	}

	// =================================================================================================================
	// PUBLIC API [VALIDATION]
	// =================================================================================================================

	@Override
	public void validate() throws OdysseusConfigurationException {
		if (this.stopCriterion == null) {
			throw new OdysseusConfigurationException("No Stop Criterion is set up in Simulation configuration!");
		}
		if (this.mutatorSelector == null) {
			throw new OdysseusConfigurationException("No MutatorSelector is set up in Simulation configuration!");
		}
	}

}
