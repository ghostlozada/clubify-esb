package com.clubify.web.exception;

/**
 * Excepcion que se propaga cuando no se ha encuentrado el registro solicitado.
 * @author Gux Lozada
 */
public class EntidadNotFoundException extends RuntimeException {
    /** Id por JVM. */
    private static final long serialVersionUID = 1L;

    /**
     * Crea una nueva instancia de la clase EntidadNotFoundException
     */
    public EntidadNotFoundException() {
        super();
    }

    /**
     * Crea una nueva instancia de la clase EntidadNotFoundException
     * @param message
     * @param cause
     */
    public EntidadNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Crea una nueva instancia de la clase EntidadNotFoundException
     * @param message
     */
    public EntidadNotFoundException(final String message) {
        super(message);
    }

    /**
     * Crea una nueva instancia de la clase EntidadNotFoundException
     * @param cause
     */
    public EntidadNotFoundException(final Throwable cause) {
        super(cause);
    }
}
