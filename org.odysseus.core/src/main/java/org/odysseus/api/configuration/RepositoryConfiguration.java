package org.odysseus.api.configuration;

import org.odysseus.api.RepositoryConnector;

public interface RepositoryConfiguration extends PartialOdysseusConfiguration {

	public RepositoryConnector getConnector();

	public void setConnector(RepositoryConnector connector);

}
