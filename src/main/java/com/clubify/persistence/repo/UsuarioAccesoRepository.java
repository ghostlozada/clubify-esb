package com.clubify.persistence.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.clubify.persistence.modelo.UsuarioAcceso;

/**
 * Proxy para operaciones crud de la entidad.
 * @author Gux Lozada.
 */
public interface UsuarioAccesoRepository extends CrudRepository<UsuarioAcceso, Long> {
    /**
     * Obtiene el usuario por el correo.
     * @param email
     * @return
     */
    List<UsuarioAcceso> findByEmail(String email);
}
