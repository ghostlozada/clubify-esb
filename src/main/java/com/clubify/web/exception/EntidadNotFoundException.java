package com.clubify.web.exception;

/**
 * Excepcion que se propaga cuando no se ha encuentrado el registro solicitado.
 * @author Gux Lozada
 */
public class EntidadNotFoundException extends RuntimeException {
    public EntidadNotFoundException() {
        super();
    }

    public EntidadNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public EntidadNotFoundException(final String message) {
        super(message);
    }

    public EntidadNotFoundException(final Throwable cause) {
        super(cause);
    }
}
