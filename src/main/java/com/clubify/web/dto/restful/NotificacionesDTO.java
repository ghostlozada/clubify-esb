package com.clubify.web.dto.restful;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.clubify.persistence.modelo.Notificacion;

/**
 * @author Gux Lozada
 */
public class NotificacionesDTO implements Serializable {
    /** Id por JVM. */
    private static final long serialVersionUID = 630925220408133984L;
    private List<Notificacion> notificaciones = new ArrayList<>();

    /**
     * Crea una nueva instancia de la clase NotificacionesDTO
     */
    public NotificacionesDTO() {
        super();
    }

    /**
     * Crea una nueva instancia de la clase NotificacionesDTO
     * @param notificaciones
     */
    public NotificacionesDTO(List<Notificacion> notificaciones) {
        super();
        if (notificaciones != null) {
            this.notificaciones.addAll(notificaciones);
        }
    }

    /**
     * Obtiene el atributo de clase: "notificaciones"
     * @return el/la notificaciones
     */
    public List<Notificacion> getNotificaciones() {
        return this.notificaciones;
    }

    /**
     * Asigna valor al atributo de clase: "notificaciones"
     * @param notificaciones el/la notificaciones para asignar el valor
     */
    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }
}
