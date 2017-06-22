package org.odysseus.api.configuration;

import org.odysseus.exceptions.OdysseusConfigurationException;

public interface PartialOdysseusConfiguration {

	public void validate() throws OdysseusConfigurationException;

}
