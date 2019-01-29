package com.clubify.firebase;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

/**
 * @author Gux Lozada
 */
@Generated("net.hexar.json2pojo")
public class NotificacionPayload {
    // @SerializedName("data")
    // private DataDTO dataDTO;
    @SerializedName("notification")
    private NotificationDTO notification;
    @SerializedName("to")
    private String to;

    /**
     * Crea una nueva instancia de la clase NotificacionPayload
     * @param to
     */
    public NotificacionPayload(String to, String titulo, String body) {
        super();
        this.to = to;
        this.notification = new NotificationDTO(titulo, body);
    }
    // /**
    // * Obtiene el atributo de clase: "data"
    // * @return el/la data
    // */
    // public DataDTO getData() {
    // return this.dataDTO;
    // }
    //
    // /**
    // * Asigna valor al atributo de clase: "data"
    // * @param dataDTO el/la data para asignar el valor
    // */
    // public void setData(DataDTO dataDTO) {
    // this.dataDTO = dataDTO;
    // }

    /**
     * Obtiene el atributo de clase: "to"
     * @return el/la to
     */
    public String getTo() {
        return this.to;
    }

    /**
     * Asigna valor al atributo de clase: "to"
     * @param to el/la to para asignar el valor
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Obtiene el atributo de clase: "notification"
     * @return el/la notification
     */
    public NotificationDTO getNotification() {
        return this.notification;
    }

    /**
     * Asigna valor al atributo de clase: "notification"
     * @param notification el/la notification para asignar el valor
     */
    public void setNotification(NotificationDTO notification) {
        this.notification = notification;
    }
}
