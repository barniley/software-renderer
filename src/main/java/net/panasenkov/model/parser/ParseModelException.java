package net.panasenkov.model.parser;

public class ParseModelException extends RuntimeException {
	public ParseModelException() {
	}

	public ParseModelException(String message) {
		super(message);
	}

	public ParseModelException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParseModelException(Throwable cause) {
		super(cause);
	}

	public ParseModelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
