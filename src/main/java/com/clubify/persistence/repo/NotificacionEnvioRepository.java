package com.clubify.persistence.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.clubify.persistence.modelo.NotificacionEnvio;

/**
 * Proxy para operaciones crud de la entidad NotificacionEnvio.
 * @author Gux Lozada.
 */
public interface NotificacionEnvioRepository extends PagingAndSortingRepository<NotificacionEnvio, Long> {
    /**
     * Notificaciones pendientes de envio paginado.
     * @param pageable Rango del bloque
     * @return
     */
    @Query("FROM NotificacionEnvio n ORDER BY n.codNotificacion")
    List<NotificacionEnvio> pendientes(Pageable pageable);

    /**
     * Notificaciones pendientes de envio por destinatario.
     * @param destinatario Correo del destinatario.
     * @param pageable Info de paginacion
     * @return
     */
    Page<NotificacionEnvio> findByDestinatario(String destinatario, Pageable pageable);
}
