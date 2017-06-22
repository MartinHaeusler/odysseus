package org.odysseus.api.configuration;

import org.odysseus.spi.OdysseusModule;

public interface ModuleConfiguration extends PartialOdysseusConfiguration {

	public void setActiveModule(String module);

	public void setActiveModule(Class<? extends OdysseusModule> module);

	public OdysseusModule getActiveModule();

}
