package org.odysseus.api;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.resource.Resource;
import org.odysseus.api.configuration.EcoreConfiguration;
import org.odysseus.api.configuration.ModuleConfiguration;
import org.odysseus.api.configuration.RandomConfiguration;
import org.odysseus.api.configuration.RepositoryConfiguration;
import org.odysseus.api.configuration.SimulationConfiguration;
import org.odysseus.internal.OdysseusEPackageRegistry;
import org.odysseus.internal.OdysseusImpl;
import org.odysseus.spi.OdysseusModule;

public interface Odysseus {

	// =================================================================================================================
	// STATIC FACTORY METHODS
	// =================================================================================================================

	public static Odysseus newInstance() {
		OdysseusEPackageRegistry.eINSTANCE.initialize();
		return new OdysseusImpl();
	}

	// =================================================================================================================
	// UTILITIES
	// =================================================================================================================

	public Collection<? extends OdysseusModule> getAvailableModules();

	public RepositoryConnector createResourceConnector(Resource resource, boolean indexed);

	public RepositoryConnector createResourceConnector(Resource resource, boolean indexed, Map<?, ?> loadOptions,
			Map<?, ?> saveOptions);

	public RepositoryConnector createResourceConnector(Resource resource, boolean indexed,
			Supplier<Map<?, ?>> loadOptionsProvider, Supplier<Map<?, ?>> saveOptionsProvider);

	public RepositoryConnector createResourceConnector(Resource resource, boolean indexed, Map<?, ?> loadOptions,
			Map<?, ?> saveOptions, Supplier<InputStream> inputStreamProvider,
			Supplier<OutputStream> outputStreamProvider);

	public RepositoryConnector createResourceConnector(Resource resource, boolean indexed,
			Supplier<Map<?, ?>> loadOptionsProvider, Supplier<Map<?, ?>> saveOptionsProvider,
			Supplier<InputStream> inputStreamProvider, Supplier<OutputStream> outputStreamProvider);

	// =================================================================================================================
	// CONFIGURATION
	// =================================================================================================================

	public ModuleConfiguration moduleConfig();

	public EcoreConfiguration ecoreConfig();

	public RandomConfiguration randomGeneratorConfig();

	public SimulationConfiguration simulationConfig();

	public RepositoryConfiguration repositoryConfig();

	// =================================================================================================================
	// SIMULATION EXECUTION
	// =================================================================================================================

	public void runSimulation();
}
