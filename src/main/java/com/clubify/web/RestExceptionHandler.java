package com.clubify.web;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.clubify.web.exception.EntidadIdMismatchException;
import com.clubify.web.exception.EntidadNotFoundException;

/**
 * Interceptor de excepciones para controlar la respuesta Restful apropiada.
 * @author Gux Lozada
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler({ EntidadNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Registro no encontrado", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    /**
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler({ EntidadIdMismatchException.class, ConstraintViolationException.class,
            DataIntegrityViolationException.class })
    public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
