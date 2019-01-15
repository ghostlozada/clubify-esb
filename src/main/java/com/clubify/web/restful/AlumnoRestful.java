package com.clubify.web.restful;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clubify.persistence.modelo.Alumno;
import com.clubify.persistence.repo.AlumnoRepository;
import com.clubify.web.exception.EntidadIdMismatchException;
import com.clubify.web.exception.EntidadNotFoundException;

/**
 * Servicio Restful de la entidad 'Notificacion'.
 * @author Gux Lozada
 */
@RestController
@RequestMapping("/restapi/alumnos")
public class AlumnoRestful {
    @Autowired
    private AlumnoRepository alumnoRepository;

    /**
     * Actualiza el identificador del telefono del alumno relacionado al email.
     * @param email
     * @param tokenTelefono
     */
    @PutMapping("/idtelefono/{email}/{tokenTelefono}")
    public void actualizarIdTelefono(@PathVariable String email, @PathVariable String tokenTelefono) {
        if (StringUtils.isBlank(email)) {
            throw new EntidadIdMismatchException("No existe un alumno relacionado al correo: nulo");
        }
        List<Alumno> registros = this.alumnoRepository.findByEmail(email);
        if (registros == null || registros.isEmpty()) {
            throw new EntidadNotFoundException("No existe un alumno relacionado al correo: " + email);
        } else if (registros.size() != 1) {
            throw new EntidadNotFoundException("Existe multiples alumnos relacionados al correo: " + email);
        }
        Alumno alumno = registros.get(0);
        alumno.setIdTelefono(tokenTelefono);
        this.alumnoRepository.save(alumno);
    }

    /**
     * elimina el identificador del telefono del alumno relacionado al email.
     * @param email
     */
    // TODO: GLOZADA Temporalmente para cambiar al estado=1 (PENDIENTE)
    @PutMapping("/borraridtelefono/{email}")
    public void borrarIdTelefono(@PathVariable String email) {
        if (StringUtils.isBlank(email)) {
            throw new EntidadIdMismatchException("No existe un alumno relacionado al correo: nulo");
        }
        List<Alumno> registros = this.alumnoRepository.findByEmail(email);
        if (registros == null || registros.isEmpty()) {
            throw new EntidadNotFoundException("No existe un alumno relacionado al correo: " + email);
        } else if (registros.size() != 1) {
            throw new EntidadNotFoundException("Existe multiples alumnos relacionados al correo: " + email);
        }
        Alumno alumno = registros.get(0);
        alumno.setIdTelefono(null);
        this.alumnoRepository.save(alumno);
    }
}
