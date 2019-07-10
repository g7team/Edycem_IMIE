package fr.imie.edycem.exception;

public class EdycemResourceNotFoundException extends RuntimeException  {

    public EdycemResourceNotFoundException() {
        super();
    }

    public EdycemResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public EdycemResourceNotFoundException(final String message) {
        super(message);
    }

    public EdycemResourceNotFoundException(final Throwable cause) {
        super(cause);
    }
}
