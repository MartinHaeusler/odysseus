package org.odysseus.exceptions;

public class ModelGenerationException extends OdysseusException {

	public ModelGenerationException() {
		super();
	}

	protected ModelGenerationException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ModelGenerationException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ModelGenerationException(final String message) {
		super(message);
	}

	public ModelGenerationException(final Throwable cause) {
		super(cause);
	}

}
