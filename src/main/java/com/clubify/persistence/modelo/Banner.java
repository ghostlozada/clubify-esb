package com.clubify.persistence.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidad relacionada a la tabla 'COL_URL_BANNER'
 * @author Gux Lozada
 */
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "COL_URL_BANNER")
public class Banner implements Serializable {
    /** Id por JVM. */
    private static final long serialVersionUID = 8271989844630926208L;
    /** cod_url number. */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    @Column(name = "COD_URL", nullable = false)
    private Long id;
    /** url varchar2(1000). */
    @JsonProperty("imageUrl")
    @Column(name = "URL", length = 1000)
    private String url;
    /** descripcion varchar2(4000). */
    @JsonProperty("link")
    @Column(length = 4000)
    private String descripcion;

    /**
     * Crea una nueva instancia de la clase UrlBanner
     */
    public Banner() {
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
     * Obtiene el atributo de clase: "url"
     * @return el/la url
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Asigna valor al atributo de clase: "url"
     * @param url el/la url para asignar el valor
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Obtiene el atributo de clase: "descripcion"
     * @return el/la descripcion
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Asigna valor al atributo de clase: "descripcion"
     * @param descripcion el/la descripcion para asignar el valor
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
