package net.panasenkov.model.loader;

public class ModelLoaderException extends RuntimeException {
    public ModelLoaderException() {
    }

    public ModelLoaderException(String message) {
        super(message);
    }

    public ModelLoaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelLoaderException(Throwable cause) {
        super(cause);
    }

    public ModelLoaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
