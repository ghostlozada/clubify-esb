package com.clubify.firebase;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

/**
 * @author Gux Lozada
 */
@Generated("net.hexar.json2pojo")
public class NotificationDTO {
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    /**
     * Crea una nueva instancia de la clase NotificationDTO
     * @param title
     * @param body
     */
    public NotificationDTO(String title, String body) {
        super();
        this.title = title;
        this.body = body;
    }

    /**
     * Obtiene el atributo de clase: "body"
     * @return el/la body
     */
    public String getBody() {
        return this.body;
    }

    /**
     * Asigna valor al atributo de clase: "body"
     * @param body el/la body para asignar el valor
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Obtiene el atributo de clase: "title"
     * @return el/la title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Asigna valor al atributo de clase: "title"
     * @param title el/la title para asignar el valor
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
