package org.odysseus.exceptions;

public class XMIConversionFailedException extends OdysseusException {

	public XMIConversionFailedException() {
		super();
	}

	protected XMIConversionFailedException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public XMIConversionFailedException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public XMIConversionFailedException(final String message) {
		super(message);
	}

	public XMIConversionFailedException(final Throwable cause) {
		super(cause);
	}

}
