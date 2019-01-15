package com.clubify.persistence.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidad relacionada a la vista 'COL_V_ACCESO'
 * @author Gux Lozada
 */
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "COL_V_ACCESO")
public class UsuarioAcceso implements Serializable {
    /** Id por JVM. */
    private static final long serialVersionUID = 8896801355352688125L;
    /** COD_ALUMNO number. */
    @JsonIgnore
    @Id
    @Column(name = "COD_ALUMNO", nullable = false)
    private Long codAlumno;
    /** email varchar2(500). */
    @JsonProperty("id")
    @Column(name = "EMAIL", length = 500)
    private String email;
    /** clave varchar2(4000). */
    @JsonProperty("passwd")
    @Column(length = 4000)
    private String clave;
    @Transient
    private String estado = "1";

    /**
     * Crea una nueva instancia de la clase UrlBanner
     */
    public UsuarioAcceso() {
        super();
    }

    /**
     * Obtiene el atributo de clase: "codAlumno"
     * @return el/la codAlumno
     */
    public Long getCodAlumno() {
        return this.codAlumno;
    }

    /**
     * Asigna valor al atributo de clase: "codAlumno"
     * @param codAlumno el/la codAlumno para asignar el valor
     */
    public void setCodAlumno(Long codAlumno) {
        this.codAlumno = codAlumno;
    }

    /**
     * Obtiene el atributo de clase: "email"
     * @return el/la email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Asigna valor al atributo de clase: "email"
     * @param email el/la email para asignar el valor
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el atributo de clase: "clave"
     * @return el/la clave
     */
    public String getClave() {
        return this.clave;
    }

    /**
     * Asigna valor al atributo de clase: "clave"
     * @param clave el/la clave para asignar el valor
     */
    public void setClave(String clave) {
        this.clave = clave;
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
