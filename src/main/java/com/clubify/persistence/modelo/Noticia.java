package com.clubify.persistence.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidad relacionada a la tabla 'COL_NOTICIAS_HOME'
 * @author Gux Lozada
 */
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "COL_NOTICIAS_HOME")
public class Noticia implements Serializable {
    /** Id por JVM. */
    private static final long serialVersionUID = 1386838017633156822L;
    /** cod_noticia number. */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    @Column(name = "COD_NOTICIA", nullable = false)
    private Long id;
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
    @JsonIgnore
    @Column
    private String estado;
    @JsonProperty("short")
    @Transient
    private String tags = "Tags : ";

    /**
     * Crea una nueva instancia de la clase NoticiaHome
     */
    public Noticia() {
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

    /**
     * Obtiene el atributo de clase: "tags"
     * @return el/la tags
     */
    public String getTags() {
        return this.tags;
    }

    /**
     * Asigna valor al atributo de clase: "tags"
     * @param tags el/la tags para asignar el valor
     */
    public void setTags(String tags) {
        this.tags = tags;
    }
}
