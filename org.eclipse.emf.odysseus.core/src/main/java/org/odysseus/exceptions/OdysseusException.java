package org.odysseus.exceptions;

public class OdysseusException extends RuntimeException {

	public OdysseusException() {
		super();
	}

	protected OdysseusException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OdysseusException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public OdysseusException(final String message) {
		super(message);
	}

	public OdysseusException(final Throwable cause) {
		super(cause);
	}

}
