package com.clubify.persistence.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad relacionada a la tabla 'col_v_notificacion_envio'
 * @author Gux Lozada
 */
@Entity
@Table(name = "col_v_notificacion_envio")
public class NotificacionEnvio implements Serializable {
    /** Id por JVM. */
    private static final long serialVersionUID = 4561848583774148387L;
    @Id
    @Column(name = "COD_NOTIFICACION")
    private Long codNotificacion;
    @Column
    private String destinatario;
    @Column(name = "ID_TELEFONO")
    private String idTelefono;
    @Column
    private String titulo;
    @Column
    private String detalle;
    @Column(name = "URL_IMAGEN")
    private String urlImagen;
    @Column
    private LocalDateTime fecha;

    /**
     * Crea una nueva instancia de la clase Notificacion
     */
    public NotificacionEnvio() {
        super();
    }

    /**
     * Obtiene el atributo de clase: "codNotificacion"
     * @return el/la codNotificacion
     */
    public Long getCodNotificacion() {
        return this.codNotificacion;
    }

    /**
     * Asigna valor al atributo de clase: "codNotificacion"
     * @param codNotificacion el/la codNotificacion para asignar el valor
     */
    public void setCodNotificacion(Long codNotificacion) {
        this.codNotificacion = codNotificacion;
    }

    /**
     * Obtiene el atributo de clase: "destinatario"
     * @return el/la destinatario
     */
    public String getDestinatario() {
        return this.destinatario;
    }

    /**
     * Asigna valor al atributo de clase: "destinatario"
     * @param destinatario el/la destinatario para asignar el valor
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * Obtiene el atributo de clase: "idTelefono"
     * @return el/la idTelefono
     */
    public String getIdTelefono() {
        return this.idTelefono;
    }

    /**
     * Asigna valor al atributo de clase: "idTelefono"
     * @param idTelefono el/la idTelefono para asignar el valor
     */
    public void setIdTelefono(String idTelefono) {
        this.idTelefono = idTelefono;
    }

    /**
     * Obtiene el atributo de clase: "titulo"
     * @return el/la titulo
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Asigna valor al atributo de clase: "titulo"
     * @param titulo el/la titulo para asignar el valor
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el atributo de clase: "detalle"
     * @return el/la detalle
     */
    public String getDetalle() {
        return this.detalle;
    }

    /**
     * Asigna valor al atributo de clase: "detalle"
     * @param detalle el/la detalle para asignar el valor
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    /**
     * Obtiene el atributo de clase: "urlImagen"
     * @return el/la urlImagen
     */
    public String getUrlImagen() {
        return this.urlImagen;
    }

    /**
     * Asigna valor al atributo de clase: "urlImagen"
     * @param urlImagen el/la urlImagen para asignar el valor
     */
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    /**
     * Obtiene el atributo de clase: "fecha"
     * @return el/la fecha
     */
    public LocalDateTime getFecha() {
        return this.fecha;
    }

    /**
     * Asigna valor al atributo de clase: "fecha"
     * @param fecha el/la fecha para asignar el valor
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "NotificacionEnvio [codNotificacion=" + this.codNotificacion + ", destinatario=" + this.destinatario
                + ", idTelefono=" + this.idTelefono + ", titulo=" + this.titulo + "]";
    }
}
