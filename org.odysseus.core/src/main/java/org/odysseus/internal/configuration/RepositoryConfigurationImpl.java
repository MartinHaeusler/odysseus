package org.odysseus.internal.configuration;

import static com.google.common.base.Preconditions.*;

import org.odysseus.api.RepositoryConnector;
import org.odysseus.api.configuration.RepositoryConfiguration;
import org.odysseus.exceptions.OdysseusConfigurationException;

public class RepositoryConfigurationImpl implements RepositoryConfiguration {

	// =================================================================================================================
	// FIELDS
	// =================================================================================================================

	protected RepositoryConnector connector;

	// =================================================================================================================
	// CONSTRUCTOR
	// =================================================================================================================

	public RepositoryConfigurationImpl() {
	}

	// =================================================================================================================
	// PUBLIC API [CONFIGURATION]
	// =================================================================================================================

	@Override
	public RepositoryConnector getConnector() {
		return this.connector;
	}

	@Override
	public void setConnector(final RepositoryConnector connector) {
		checkNotNull(connector, "Precondition violation - argument 'connector' must not be NULL!");
		this.connector = connector;
	}

	// =================================================================================================================
	// PUBLIC API [VALIDATION]
	// =================================================================================================================

	@Override
	public void validate() throws OdysseusConfigurationException {
		if (this.connector == null) {
			throw new OdysseusConfigurationException("No RepositoryConnector is set up in Repository configuration!");
		}
	}

}
