package com.clubify.persistence.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidad relacionada a la tabla 'COL_NOTIFICACION'
 * @author Gux Lozada
 */
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "COL_V_NOTIFICACION")
public class Notificacion implements Serializable {
    /** Id por JVM. */
    private static final long serialVersionUID = -4830012568928647677L;
    /** cod_notificacion number. */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    @Column(name = "COD_NOTIFICACION", nullable = false)
    private Long id;
    /** destinatario varchar2(400) not null. */
    @JsonIgnore
    @Column(nullable = false, length = 400)
    private String destinatario;
    /** id_telefono varchar2(200) not null. */
    @JsonIgnore
    @Column(name = "ID_TELEFONO", nullable = false, length = 200)
    private String idTelefono;
    /** titulo varchar2(200) not null. */
    @Column(nullable = false, length = 200)
    private String titulo;
    /** detalle varchar2(4000) not null. */
    @JsonProperty("descripcion")
    @Column(name = "DETALLE", nullable = false, length = 4000)
    private String detalle;
    /** url_imagen varchar2(1000). */
    @JsonProperty("imageUrl")
    @Column(name = "URL_IMAGEN", length = 1000)
    private String urlImagen;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column
    private LocalDateTime fecha;
    @Column
    private String estado;

    /**
     * Crea una nueva instancia de la clase Notificacion
     */
    public Notificacion() {
        super();
    }

    /**
     * Obtiene el atributo de clase: "id"
     * @return el/la id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Asigna valor al atributo de clase: "id"
     * @param id el/la id para asignar el valor
     */
    public void setId(Long id) {
        this.id = id;
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
     * Obtiene el atributo de clase: "estado"
     * @return el/la estado
     */
    public String getEstado() {
        return this.estado;
    }

    /**
     * Asigna valor al atributo de clase: "estado"
     * @param estado el/la estado para asignar el valor
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
