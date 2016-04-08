package cn.itcast.exceptions;

public class UserexitException extends Exception {

    public UserexitException() {
        super();
    }

    public UserexitException(String message) {
        super(message);
    }

    public UserexitException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserexitException(Throwable cause) {
        super(cause);
    }

    protected UserexitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
