package org.odysseus.internal;

import static com.google.common.base.Preconditions.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.resource.Resource;
import org.odysseus.api.Odysseus;
import org.odysseus.api.RepositoryConnector;
import org.odysseus.api.configuration.EcoreConfiguration;
import org.odysseus.api.configuration.ModuleConfiguration;
import org.odysseus.api.configuration.PartialOdysseusConfiguration;
import org.odysseus.api.configuration.RandomConfiguration;
import org.odysseus.api.configuration.RepositoryConfiguration;
import org.odysseus.api.configuration.SimulationConfiguration;
import org.odysseus.exceptions.ModelGenerationException;
import org.odysseus.exceptions.NoMoreApplicableMutatorsException;
import org.odysseus.exceptions.OdysseusConfigurationException;
import org.odysseus.exceptions.OdysseusModuleLoadingException;
import org.odysseus.internal.configuration.EcoreConfigurationImpl;
import org.odysseus.internal.configuration.ModuleConfigurationImpl;
import org.odysseus.internal.configuration.RandomConfigurationImpl;
import org.odysseus.internal.configuration.RepositoryConfigurationImpl;
import org.odysseus.internal.configuration.SimulationConfigurationImpl;
import org.odysseus.internal.connector.BasicResourceRepositoryConnector;
import org.odysseus.internal.connector.IndexedResourceRepositoryConnector;
import org.odysseus.internal.spi.loader.OdysseusModuleLoader;
import org.odysseus.internal.statistics.MutatorStatistics;
import org.odysseus.internal.statistics.MutatorStatisticsImpl;
import org.odysseus.internal.util.ReflectionUtils;
import org.odysseus.spi.Mutator;
import org.odysseus.spi.OdysseusModule;
import org.odysseus.spi.exceptions.ModificationNotApplicableException;
import org.odysseus.spi.exceptions.NotEnoughElementsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class OdysseusImpl implements Odysseus {

	private static final Logger LOG = LoggerFactory.getLogger(OdysseusImpl.class);

	// =================================================================================================================
	// FIELDS
	// =================================================================================================================

	protected final EcoreConfiguration ecoreConfig;
	protected final ModuleConfiguration moduleConfig;
	protected final RandomConfiguration randomConfig;
	protected final RepositoryConfiguration repositoryConfig;
	protected final SimulationConfiguration simulationConfig;

	// =================================================================================================================
	// CONSTRUCTOR
	// =================================================================================================================

	public OdysseusImpl() {
		this.ecoreConfig = new EcoreConfigurationImpl();
		this.moduleConfig = new ModuleConfigurationImpl();
		this.randomConfig = new RandomConfigurationImpl();
		this.repositoryConfig = new RepositoryConfigurationImpl();
		this.simulationConfig = new SimulationConfigurationImpl();
	}

	// =================================================================================================================
	// PUBLIC API [UTILITIES]
	// =================================================================================================================

	@Override
	public Collection<? extends OdysseusModule> getAvailableModules() {
		return OdysseusModuleLoader.loadModules();
	}

	@Override
	public RepositoryConnector createResourceConnector(final Resource resource, final boolean indexed) {
		checkNotNull(resource, "Precondition violation - argument 'resource' must not be NULL!");
		if (indexed == false) {
			return new BasicResourceRepositoryConnector(resource, null, null, null, null);
		} else {
			return new IndexedResourceRepositoryConnector(resource, null, null, null, null);
		}
	}

	@Override
	public RepositoryConnector createResourceConnector(final Resource resource, final boolean indexed,
			final Map<?, ?> loadOptions, final Map<?, ?> saveOptions) {
		checkNotNull(resource, "Precondition violation - argument 'resource' must not be NULL!");
		checkNotNull(loadOptions, "Precondition violation - argument 'loadOptions' must not be NULL!");
		checkNotNull(saveOptions, "Precondition violation - argument 'saveOptions' must not be NULL!");
		Supplier<Map<?, ?>> loadSupplier = () -> Maps.newHashMap(loadOptions);
		Supplier<Map<?, ?>> saveSupplier = () -> Maps.newHashMap(saveOptions);
		if (indexed) {
			return new BasicResourceRepositoryConnector(resource, loadSupplier, null, saveSupplier, null);
		} else {
			return new IndexedResourceRepositoryConnector(resource, loadSupplier, null, saveSupplier, null);
		}
	}

	@Override
	public RepositoryConnector createResourceConnector(final Resource resource, final boolean indexed,
			final Map<?, ?> loadOptions, final Map<?, ?> saveOptions, final Supplier<InputStream> inputStreamProvider,
			final Supplier<OutputStream> outputStreamProvider) {
		checkNotNull(resource, "Precondition violation - argument 'resource' must not be NULL!");
		checkNotNull(loadOptions, "Precondition violation - argument 'loadOptions' must not be NULL!");
		checkNotNull(saveOptions, "Precondition violation - argument 'saveOptions' must not be NULL!");
		checkNotNull(inputStreamProvider, "Precondition violation - argument 'inputStreamProvider' must not be NULL!");
		checkNotNull(outputStreamProvider,
				"Precondition violation - argument 'outputStreamProvider' must not be NULL!");
		Supplier<Map<?, ?>> loadSupplier = () -> Maps.newHashMap(loadOptions);
		Supplier<Map<?, ?>> saveSupplier = () -> Maps.newHashMap(saveOptions);
		if (indexed) {
			return new BasicResourceRepositoryConnector(resource, loadSupplier, inputStreamProvider, saveSupplier,
					outputStreamProvider);
		} else {
			return new IndexedResourceRepositoryConnector(resource, loadSupplier, inputStreamProvider, saveSupplier,
					outputStreamProvider);
		}
	}

	@Override
	public RepositoryConnector createResourceConnector(final Resource resource, final boolean indexed,
			final Supplier<Map<?, ?>> loadOptionsProvider, final Supplier<Map<?, ?>> saveOptionsProvider) {
		checkNotNull(resource, "Precondition violation - argument 'resource' must not be NULL!");
		checkNotNull(loadOptionsProvider, "Precondition violation - argument 'loadOptionsProvider' must not be NULL!");
		checkNotNull(saveOptionsProvider, "Precondition violation - argument 'saveOptionsProvider' must not be NULL!");
		if (indexed) {
			return new BasicResourceRepositoryConnector(resource, loadOptionsProvider, null, saveOptionsProvider, null);
		} else {
			return new IndexedResourceRepositoryConnector(resource, loadOptionsProvider, null, saveOptionsProvider,
					null);
		}
	}

	@Override
	public RepositoryConnector createResourceConnector(final Resource resource, final boolean indexed,
			final Supplier<Map<?, ?>> loadOptionsProvider, final Supplier<Map<?, ?>> saveOptionsProvider,
			final Supplier<InputStream> inputStreamProvider, final Supplier<OutputStream> outputStreamProvider) {
		checkNotNull(resource, "Precondition violation - argument 'resource' must not be NULL!");
		checkNotNull(loadOptionsProvider, "Precondition violation - argument 'loadOptionsProvider' must not be NULL!");
		checkNotNull(saveOptionsProvider, "Precondition violation - argument 'saveOptionsProvider' must not be NULL!");
		checkNotNull(inputStreamProvider, "Precondition violation - argument 'inputStreamProvider' must not be NULL!");
		checkNotNull(outputStreamProvider,
				"Precondition violation - argument 'outputStreamProvider' must not be NULL!");
		if (indexed) {
			return new BasicResourceRepositoryConnector(resource, loadOptionsProvider, inputStreamProvider,
					saveOptionsProvider, outputStreamProvider);
		} else {
			return new IndexedResourceRepositoryConnector(resource, loadOptionsProvider, inputStreamProvider,
					saveOptionsProvider, outputStreamProvider);
		}
	}

	// =================================================================================================================
	// PUBLIC API [CONFIGURATION]
	// =================================================================================================================

	@Override
	public ModuleConfiguration moduleConfig() {
		return this.moduleConfig;
	}

	@Override
	public EcoreConfiguration ecoreConfig() {
		return this.ecoreConfig;
	}

	@Override
	public RandomConfiguration randomGeneratorConfig() {
		return this.randomConfig;
	}

	@Override
	public SimulationConfiguration simulationConfig() {
		return this.simulationConfig;
	}

	@Override
	public RepositoryConfiguration repositoryConfig() {
		return this.repositoryConfig;
	}

	// =================================================================================================================
	// PUBLIC API [EXECUTION]
	// =================================================================================================================

	@Override
	public void runSimulation() {
		// first, validate the configuration
		this.validateConfiguration();
		LOG.info("STARTING ODYSSEUS MODEL GENERATION");
		// create the context
		ModelGenerationContextImpl context = new ModelGenerationContextImpl(this);
		// create the list of available mutators
		Collection<? extends Mutator> moduleMutators = this.moduleConfig().getActiveModule().getMutators();
		if (moduleMutators == null || moduleMutators.isEmpty()) {
			throw new OdysseusModuleLoadingException("The Module '"
					+ this.moduleConfig().getActiveModule().getQualifiedName() + "' does not specify any Mutators!");
		}
		List<Mutator> mutators = Lists.newArrayList(this.moduleConfig().getActiveModule().getMutators());
		// mutator exclusion
		this.removeExcludedMutators(mutators);
		// tell the repository that we are about to start the simulation
		this.repositoryConfig().getConnector().start();
		// prepare the variables that we use to keep track of the flush intervals
		int batchSize = 0;
		int maxBatchSize = this.simulationConfig().getFlushInterval();
		// prepare the state map for the mutators
		Map<String, Object> mutatorState = Maps.newHashMap();
		// prepare the statistics object
		MutatorStatistics statistics = this.createEmptyStatistics();
		// run the generator until the stop criterion is reached
		while (this.simulationConfig().getStopCriterion().test(context) == false) {
			if (context.getIteration() % 100 == 0) {
				LOG.info("Executing iteration #" + context.getIteration() + ".");
			}
			List<Mutator> availableMutators = Lists.newArrayList(mutators);
			Mutator chosenMutator = null;
			boolean done = false;
			while (done == false) {
				try {
					// choose the next mutator
					chosenMutator = this.selectNextMutator(context, availableMutators);
					statistics.mutatorAttempt(chosenMutator);
					chosenMutator.apply(context, mutatorState);
					LOG.debug("Iteration #" + context.getIteration() + ": Successfully applied mutator '"
							+ chosenMutator.getName() + "' (" + chosenMutator.getClass().getCanonicalName() + ").");
					// successfully applied the mutator
					statistics.mutatorSuccessful(chosenMutator);
					done = true;
				} catch (ModificationNotApplicableException | NotEnoughElementsException e) {
					LOG.debug("Failed to apply mutator '" + chosenMutator.getName() + "' ("
							+ chosenMutator.getClass().getCanonicalName() + "). Will try one of the "
							+ (availableMutators.size() - 1) + " other mutators. Reason: " + e.toString());
					// failed to apply mutator; retry the iteration and choose another one
					availableMutators.remove(chosenMutator);
					// if we don't have any other mutators available, then we're out of luck...
					if (availableMutators.isEmpty()) {
						throw new NoMoreApplicableMutatorsException(
								"Model generation reached a state where none of the " + mutators.size()
										+ " available mutators were applicable. To fix this, remove mutator exclusions, "
										+ "or define more mutators in your module.");
					}
				}
			}
			// report to the context that the iteration was completed successfully
			context.iterationDone();
			batchSize++;
			// flush the repository, if required
			if (maxBatchSize > 0 && batchSize >= maxBatchSize) {
				LOG.debug("Flushing repository changes.");
				this.repositoryConfig().getConnector().flush();
				batchSize = 0;
				this.logStatistics(statistics, this.moduleConfig().getActiveModule().getMutators());
			}
		}
		// do a final flush on the repository (if required)
		if (maxBatchSize > 0 && batchSize > 0) {
			LOG.debug("Flushing repository changes.");
			this.repositoryConfig().getConnector().flush();
			batchSize = 0;
		}
		LOG.info("MODEL GENERATION TERMINATED SUCCESSFULLY AFTER " + context.getIteration() + " ITERATIONS.");
		LOG.debug("Saving repository state.");
		// report to the repository that we're done
		this.repositoryConfig().getConnector().done();
		this.logStatistics(statistics, this.moduleConfig().getActiveModule().getMutators());
	}

	// =================================================================================================================
	// HELPER METHODS
	// =================================================================================================================

	protected void validateConfiguration() {
		Set<PartialOdysseusConfiguration> configs = Sets.newHashSet();
		Set<Field> allFields = ReflectionUtils.getAllFields(this.getClass());
		for (Field field : allFields) {
			try {
				if (PartialOdysseusConfiguration.class.isAssignableFrom(field.getType())) {
					field.setAccessible(true);
					PartialOdysseusConfiguration config = (PartialOdysseusConfiguration) field.get(this);
					if (config != null) {
						configs.add(config);
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// print a warning and ignore the field
				LOG.warn("Failed to read configuration field via reflection. Will ignore this field: '" + field
						+ "'. Cause: " + e.toString());
			}
		}
		List<OdysseusConfigurationException> configExceptions = Lists.newArrayList();
		for (PartialOdysseusConfiguration config : configs) {
			try {
				config.validate();
			} catch (OdysseusConfigurationException e) {
				configExceptions.add(e);
			}
		}
		if (configExceptions.isEmpty() == false) {
			StringBuilder msg = new StringBuilder();
			msg.append("The following errors occurred when validating the Odysseus Configuration:\n");
			for (OdysseusConfigurationException exception : configExceptions) {
				msg.append("\t- ");
				msg.append(exception.getLocalizedMessage());
				msg.append("\n");
			}
			msg.append("Please fix the configuration issues listed above before running a simulation.");
			throw new OdysseusConfigurationException(msg.toString());
		}
	}

	protected void removeExcludedMutators(final List<Mutator> mutators) {
		List<Mutator> excludedMutators = Lists.newArrayList();
		mutators.removeIf(mutator -> {
			boolean exclude = this.simulationConfig().isMutatorExcluded(mutator);
			if (exclude) {
				excludedMutators.add(mutator);
			}
			return exclude;
		});
		if (LOG.isInfoEnabled() && excludedMutators.isEmpty() == false) {
			StringBuilder msg = new StringBuilder();
			msg.append("The following mutators will be excluded: ");
			for (Mutator mutator : excludedMutators) {
				msg.append("\t- " + mutator.getName() + " (class: '" + mutator.getClass().getCanonicalName()
						+ "', type: " + mutator.getMutatorType() + ")");
			}
			LOG.info(msg.toString());
		}
	}

	protected Mutator selectNextMutator(final ModelGenerationContextImpl context,
			final List<Mutator> availableMutators) {
		Mutator chosenMutator = this.simulationConfig().getMutatorSelector().selectNextMutator(context,
				availableMutators);
		if (chosenMutator == null) {
			throw new ModelGenerationException(
					"The mutator selector failed to select a mutator from the following list: " + availableMutators
							.stream().map(mutator -> mutator.getName()).collect(Collectors.toList()));
		}
		return chosenMutator;
	}

	protected MutatorStatistics createEmptyStatistics() {
		return new MutatorStatisticsImpl();
	}

	protected void logStatistics(final MutatorStatistics statistics, final Collection<? extends Mutator> mutators) {
		if (LOG.isInfoEnabled() == false) {
			return;
		}
		StringBuilder msg = new StringBuilder();
		msg.append("\n");
		msg.append("==============================================================================================\n");
		msg.append("MUTATOR STATISTICS             |      ATTEMPTS     |      FAILURES      |       SUCCESS      |\n");
		msg.append("==============================================================================================\n");
		List<Mutator> mutatorList = Lists.newArrayList(mutators);
		Collections.sort(mutatorList, (m1, m2) -> m1.getName().compareTo(m2.getName()));
		for (Mutator mutator : mutatorList) {
			String name = mutator.getName();
			name = "  " + name;
			name = StringUtils.abbreviate(name, 30);
			name = StringUtils.rightPad(name, 30);
			String attempts = StringUtils.leftPad(String.valueOf(statistics.getAttempts(mutator)), 17);
			String failures = StringUtils.leftPad(String.valueOf(statistics.getFailedAttempts(mutator)), 18);
			String successes = StringUtils.leftPad(String.valueOf(statistics.getSuccessfulRuns(mutator)), 18);
			msg.append(name);
			msg.append(" | ");
			msg.append(attempts);
			msg.append(" | ");
			msg.append(failures);
			msg.append(" | ");
			msg.append(successes);
			msg.append(" |\n");
		}
		msg.append("==============================================================================================\n");
		LOG.info(msg.toString());
	}

}
