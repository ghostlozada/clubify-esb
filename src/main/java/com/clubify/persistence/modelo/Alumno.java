package com.clubify.persistence.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Entidad relacionada a la vista 'COL_ALUMNO'
 * @author Gux Lozada
 */
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "COL_ALUMNO")
public class Alumno implements Serializable {
    /** Id por JVM. */
    private static final long serialVersionUID = 3393480152052359619L;
    /** COD_ALUMNO number. */
    @Id
    @Column(name = "COD_ALUMNO", nullable = false)
    private Long codAlumno;
    /** email varchar2(500). */
    @Column(name = "EMAIL", length = 500)
    private String email;
    /** clave varchar2(4000). */
    @Column(name = "ID_TELEFONO", length = 200)
    private String idTelefono;

    /**
     * Crea una nueva instancia de la clase UrlBanner
     */
    public Alumno() {
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
}
