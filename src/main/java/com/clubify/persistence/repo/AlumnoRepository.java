package com.clubify.persistence.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.clubify.persistence.modelo.Alumno;

/**
 * Proxy para operaciones crud de la entidad.
 * @author Gux Lozada.
 */
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
    /**
     * Consulta el alumno relacionado al email.
     * @param email
     * @return
     */
    List<Alumno> findByEmail(String email);
}
