package com.clubify.firebase;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

/**
 * @author Gux Lozada
 */
@Generated("net.hexar.json2pojo")
public class DataDTO {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    @SerializedName("Mensaje")
    private String mensaje;
    @SerializedName("score")
    private String score = "N/A";
    @SerializedName("time")
    private String time;

    /**
     * Crea una nueva instancia de la clase NotificationData2
     * @param mensaje
     */
    public DataDTO(String mensaje) {
        super();
        this.mensaje = "Mensaje de prueba clubify-notificiones";
        this.time = LocalTime.now().format(formatter);
    }

    /**
     * Obtiene el atributo de clase: "mensaje"
     * @return el/la mensaje
     */
    public String getMensaje() {
        return this.mensaje;
    }

    /**
     * Asigna valor al atributo de clase: "mensaje"
     * @param mensaje el/la mensaje para asignar el valor
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Obtiene el atributo de clase: "score"
     * @return el/la score
     */
    public String getScore() {
        return this.score;
    }

    /**
     * Asigna valor al atributo de clase: "score"
     * @param score el/la score para asignar el valor
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * Obtiene el atributo de clase: "time"
     * @return el/la time
     */
    public String getTime() {
        return this.time;
    }

    /**
     * Asigna valor al atributo de clase: "time"
     * @param time el/la time para asignar el valor
     */
    public void setTime(String time) {
        this.time = time;
    }
}
