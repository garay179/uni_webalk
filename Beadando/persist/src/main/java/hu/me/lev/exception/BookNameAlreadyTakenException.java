package hu.me.lev.exception;

public class BookNameAlreadyTakenException extends Exception {
    public BookNameAlreadyTakenException() {
    }

    public BookNameAlreadyTakenException(String message) {
        super(message);
    }

    public BookNameAlreadyTakenException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookNameAlreadyTakenException(Throwable cause) {
        super(cause);
    }

    public BookNameAlreadyTakenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
