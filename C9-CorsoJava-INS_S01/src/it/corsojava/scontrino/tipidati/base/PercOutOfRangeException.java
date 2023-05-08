package it.corsojava.scontrino.tipidati.base;

public class PercOutOfRangeException extends Exception {

    public PercOutOfRangeException() {
    }

    public PercOutOfRangeException(String message) {
        super(message);
    }

    public PercOutOfRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PercOutOfRangeException(Throwable cause) {
        super(cause);
    }

    public PercOutOfRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
