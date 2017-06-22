package org.odysseus.exceptions;

public class FeatureResolutionException extends OdysseusException {

	public FeatureResolutionException() {
		super();
	}

	protected FeatureResolutionException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FeatureResolutionException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public FeatureResolutionException(final String message) {
		super(message);
	}

	public FeatureResolutionException(final Throwable cause) {
		super(cause);
	}

}
