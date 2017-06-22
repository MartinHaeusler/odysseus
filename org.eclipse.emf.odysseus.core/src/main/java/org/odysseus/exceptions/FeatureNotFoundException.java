package org.odysseus.exceptions;

public class FeatureNotFoundException extends FeatureResolutionException {

	public FeatureNotFoundException() {
		super();
	}

	protected FeatureNotFoundException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FeatureNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public FeatureNotFoundException(final String message) {
		super(message);
	}

	public FeatureNotFoundException(final Throwable cause) {
		super(cause);
	}

}
