package org.odysseus.spi.exceptions;

public class NotEnoughElementsException extends RuntimeException {

	public NotEnoughElementsException() {
		super();
	}

	protected NotEnoughElementsException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NotEnoughElementsException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public NotEnoughElementsException(final String message) {
		super(message);
	}

	public NotEnoughElementsException(final Throwable cause) {
		super(cause);
	}

}
