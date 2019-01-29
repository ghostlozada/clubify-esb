package com.clubify.persistence.repo;

import org.springframework.data.repository.CrudRepository;

import com.clubify.persistence.modelo.Notificacion;

/**
 * Proxy para operaciones crud de la entidad 'Notificacion'.
 * @author Gux Lozada.
 */
public interface NotificacionRepository extends CrudRepository<Notificacion, Long> {
}
