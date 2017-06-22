package org.odysseus.exceptions;

public class OdysseusConfigurationException extends OdysseusException {

	public OdysseusConfigurationException() {
		super();
	}

	protected OdysseusConfigurationException(final String message, final Throwable cause,
			final boolean enableSuppression, final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OdysseusConfigurationException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public OdysseusConfigurationException(final String message) {
		super(message);
	}

	public OdysseusConfigurationException(final Throwable cause) {
		super(cause);
	}

}
