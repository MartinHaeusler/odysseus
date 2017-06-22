package org.odysseus.internal.configuration;

import static com.google.common.base.Preconditions.*;

import java.lang.reflect.InvocationTargetException;

import org.odysseus.api.configuration.ModuleConfiguration;
import org.odysseus.exceptions.OdysseusConfigurationException;
import org.odysseus.exceptions.OdysseusException;
import org.odysseus.internal.spi.loader.OdysseusModuleLoader;
import org.odysseus.spi.OdysseusModule;

public class ModuleConfigurationImpl implements ModuleConfiguration {

	// =================================================================================================================
	// FIELDS
	// =================================================================================================================

	protected OdysseusModule activeModule;

	// =================================================================================================================
	// CONSTRUCTOR
	// =================================================================================================================

	public ModuleConfigurationImpl() {
	}

	// =================================================================================================================
	// PUBLIC API
	// =================================================================================================================

	@Override
	public void setActiveModule(final String module) {
		checkNotNull(module, "Precondition violation - argument 'module' must not be NULL!");
		this.activeModule = OdysseusModuleLoader.loadModule(module);
	}

	@Override
	public void setActiveModule(final Class<? extends OdysseusModule> module) {
		checkNotNull(module, "Precondition violation - argument 'module' must not be NULL!");
		try {
			this.activeModule = module.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new OdysseusException("Failed to instantiate module '" + module.getCanonicalName() + "'!", e);
		}
	}

	@Override
	public OdysseusModule getActiveModule() {
		return this.activeModule;
	}

	// =================================================================================================================
	// VALIDATION
	// =================================================================================================================

	@Override
	public void validate() throws OdysseusConfigurationException {
		if (this.activeModule == null) {
			throw new OdysseusConfigurationException("No Active Module was set up in Module configuration!");
		}
	}

}
