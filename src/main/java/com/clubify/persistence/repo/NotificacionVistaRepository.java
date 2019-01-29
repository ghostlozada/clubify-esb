package com.clubify.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.clubify.persistence.modelo.NotificacionVista;

/**
 * Proxy para operaciones crud de la entidad.
 * @author Gux Lozada.
 */
public interface NotificacionVistaRepository extends CrudRepository<NotificacionVista, Long> {
    /**
     * Consulta por destinatario (correo electronico del usuario).
     * @param destinatario correo electronico del usuario
     * @return
     */
    @Query("SELECT u FROM NotificacionVista u WHERE u.destinatario = :destinatario ORDER BY u.id desc")
    List<NotificacionVista> buscarPorDestinatario(String destinatario);
}
