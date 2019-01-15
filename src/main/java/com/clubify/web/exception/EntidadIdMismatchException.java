package com.clubify.web.exception;

/**
 * Excepcion que se propaga cuando se trata de actualizar/eliminar la informacion de un registro con informacion de clave
 * primaria(Id) diferente.
 * @author Gux Lozada.
 */
public class EntidadIdMismatchException extends RuntimeException {
    /** Id por JVM. */
    private static final long serialVersionUID = 1L;

    /**
     * Crea una nueva instancia de la clase EntidadIdMismatchException
     */
    public EntidadIdMismatchException() {
        super();
    }

    /**
     * Crea una nueva instancia de la clase EntidadIdMismatchException
     * @param message
     * @param cause
     */
    public EntidadIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Crea una nueva instancia de la clase EntidadIdMismatchException
     * @param message
     */
    public EntidadIdMismatchException(final String message) {
        super(message);
    }

    /**
     * Crea una nueva instancia de la clase EntidadIdMismatchException
     * @param cause
     */
    public EntidadIdMismatchException(final Throwable cause) {
        super(cause);
    }
}
