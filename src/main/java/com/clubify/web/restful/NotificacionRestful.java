package com.clubify.web.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clubify.persistence.modelo.NotificacionVista;
import com.clubify.persistence.repo.NotificacionVistaRepository;
import com.clubify.web.dto.restful.DetalleNotificacionDTO;
import com.clubify.web.dto.restful.NotificacionesDTO;
import com.clubify.web.exception.EntidadNotFoundException;

/**
 * Servicio Restful de la entidad 'Notificacion'.
 * @author Gux Lozada
 */
@RestController
@RequestMapping("/restapi/notificaciones")
public class NotificacionRestful {
    @Autowired
    private NotificacionVistaRepository notificacionVistaRepository;

    /**
     * Obtiene las notificaciones en estado=1(PENDIENTE) por destinatario (correo alumno).
     * @param destinatario
     * @return
     */
    @GetMapping("/correo/{destinatario}")
    public NotificacionesDTO buscarPorDestinatario(@PathVariable String destinatario) {
        return new NotificacionesDTO(this.notificacionVistaRepository.buscarPorDestinatario(destinatario));
    }

    /**
     * Buscar una notificacion por el 'id'.
     * @param id
     * @return
     */
    @GetMapping("/id/{id}")
    public DetalleNotificacionDTO buscarPorId(@PathVariable String id) {
        NotificacionVista res = this.notificacionVistaRepository.findById(Long.valueOf(id))
                .orElseThrow(EntidadNotFoundException::new);
        // TODO: GLOZADA Se asigna nulo porque en la respuesta este campo no es requerido y no
        // debe ser retornado en el Json
        res.setEstado(null);
        return new DetalleNotificacionDTO(res);
    }

    /**
     * Actualiza la notificacion relacionada al 'id' al estado=2 (LEIDO) .
     * @param id
     */
    @PutMapping("/leido/{id}")
    //// @ResponseStatus(HttpStatus.NO_CONTENT)
    public void actualizarEstadoLeido(@PathVariable String id) {
        NotificacionVista registro = this.notificacionVistaRepository.findById(Long.valueOf(id))
                .orElseThrow(EntidadNotFoundException::new);
        registro.setEstado("2");
        this.notificacionVistaRepository.save(registro);
    }

    /**
     * Actualiza la notificacion relacionada al 'id' al estado=2 (LEIDO) .
     * @param id
     */
    // TODO: GLOZADA Temporalmente para cambiar al estado=1 (PENDIENTE)
    @PutMapping("/pendiente/{id}")
    //// @ResponseStatus(HttpStatus.NO_CONTENT)
    public void actualizarEstadoPendiente(@PathVariable String id) {
        NotificacionVista registro = this.notificacionVistaRepository.findById(Long.valueOf(id))
                .orElseThrow(EntidadNotFoundException::new);
        registro.setEstado("1");
        this.notificacionVistaRepository.save(registro);
    }
}
