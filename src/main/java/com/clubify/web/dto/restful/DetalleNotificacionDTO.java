package com.clubify.web.dto.restful;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.clubify.persistence.modelo.NotificacionVista;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gux Lozada
 */
public class DetalleNotificacionDTO implements Serializable {
    /** Id por JVM. */
    private static final long serialVersionUID = -6502944315885912924L;
    @JsonProperty("DetalleNotificaciones")
    private List<NotificacionVista> notificaciones;

    /**
     * Crea una nueva instancia de la clase DetalleNotificacionDTO
     */
    public DetalleNotificacionDTO() {
        super();
    }

    /**
     * Crea una nueva instancia de la clase DetalleNotificacionDTO
     * @param notificacion
     */
    public DetalleNotificacionDTO(NotificacionVista notificacion) {
        super();
        if (notificacion != null) {
            this.notificaciones = new ArrayList<>();
            this.notificaciones.add(notificacion);
        }
    }

    /**
     * Obtiene el atributo de clase: "notificaciones"
     * @return el/la notificaciones
     */
    public List<NotificacionVista> getNotificaciones() {
        return this.notificaciones;
    }

    /**
     * Asigna valor al atributo de clase: "notificaciones"
     * @param notificaciones el/la notificaciones para asignar el valor
     */
    public void setNotificaciones(List<NotificacionVista> notificaciones) {
        this.notificaciones = notificaciones;
    }
}
