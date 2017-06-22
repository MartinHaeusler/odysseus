package org.odysseus.exceptions;

public class AmbiguousFeatureException extends FeatureResolutionException {

	public AmbiguousFeatureException() {
		super();
	}

	protected AmbiguousFeatureException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AmbiguousFeatureException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public AmbiguousFeatureException(final String message) {
		super(message);
	}

	public AmbiguousFeatureException(final Throwable cause) {
		super(cause);
	}

}
