package org.odysseus.spi.exceptions;

public class ModificationNotApplicableException extends Exception {

	public ModificationNotApplicableException() {
		super();
	}

	protected ModificationNotApplicableException(final String message, final Throwable cause,
			final boolean enableSuppression, final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ModificationNotApplicableException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ModificationNotApplicableException(final String message) {
		super(message);
	}

	public ModificationNotApplicableException(final Throwable cause) {
		super(cause);
	}

}
