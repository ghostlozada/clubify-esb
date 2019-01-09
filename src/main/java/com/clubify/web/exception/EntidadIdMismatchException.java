package com.clubify.web.exception;

/**
 * Excepcion que se propaga cuando se trata de actualizar/eliminar la informacion de un registro con informacion de clave
 * primaria(Id) diferente.
 * @author Gux Lozada.
 */
public class EntidadIdMismatchException extends RuntimeException {
    public EntidadIdMismatchException() {
        super();
    }

    public EntidadIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public EntidadIdMismatchException(final String message) {
        super(message);
    }

    public EntidadIdMismatchException(final Throwable cause) {
        super(cause);
    }
}
