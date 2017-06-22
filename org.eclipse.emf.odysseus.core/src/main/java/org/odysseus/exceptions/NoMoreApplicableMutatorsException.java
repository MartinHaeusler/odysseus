package org.odysseus.exceptions;

public class NoMoreApplicableMutatorsException extends ModelGenerationException {

	public NoMoreApplicableMutatorsException() {
		super();
	}

	protected NoMoreApplicableMutatorsException(final String message, final Throwable cause,
			final boolean enableSuppression, final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoMoreApplicableMutatorsException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public NoMoreApplicableMutatorsException(final String message) {
		super(message);
	}

	public NoMoreApplicableMutatorsException(final Throwable cause) {
		super(cause);
	}

}
