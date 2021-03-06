package com.clubify.web.dto.restful;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.clubify.persistence.modelo.NotificacionVista;

/**
 * @author Gux Lozada
 */
public class NotificacionesDTO implements Serializable {
    /** Id por JVM. */
    private static final long serialVersionUID = 630925220408133984L;
    private List<NotificacionVista> notificaciones = new ArrayList<>();

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
    public NotificacionesDTO(List<NotificacionVista> notificaciones) {
        super();
        if (notificaciones != null) {
            this.notificaciones.addAll(notificaciones);
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
