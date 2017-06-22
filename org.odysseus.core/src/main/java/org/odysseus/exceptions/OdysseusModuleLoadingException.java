package org.odysseus.exceptions;

public class OdysseusModuleLoadingException extends OdysseusException {

	public OdysseusModuleLoadingException() {
		super();
	}

	protected OdysseusModuleLoadingException(final String message, final Throwable cause,
			final boolean enableSuppression, final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OdysseusModuleLoadingException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public OdysseusModuleLoadingException(final String message) {
		super(message);
	}

	public OdysseusModuleLoadingException(final Throwable cause) {
		super(cause);
	}

}
