package com.clubify.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.clubify.persistence.modelo.Notificacion;

/**
 * Proxy para operaciones crud de la entidad.
 * @author Gux Lozada.
 */
public interface NotificacionRepository extends CrudRepository<Notificacion, Long> {
    /**
     * Consulta por destinatario (correo electronico del usuario).
     * @param destinatario correo electronico del usuario
     * @return
     */
    @Query("SELECT u FROM Notificacion u WHERE u.destinatario = :destinatario ORDER BY u.fecha desc")
    List<Notificacion> buscarPorDestinatario(String destinatario);
}
