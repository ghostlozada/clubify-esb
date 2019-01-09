package com.clubify.persistence.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Tabla demo
 * @author Gux Lozada
 */
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "TMP_DEMO_ENTIDAD")
public class DemoEntidad implements Serializable {
    /** Id por JVM */
    private static final long serialVersionUID = 9063394205714529172L;
    /** Clave compuesta. */
    @EmbeddedId
    private DemoEntidadPK pk = new DemoEntidadPK();
    /** . */
    @Column(nullable = false, length = 100)
    private String nombre;
    /** . */
    @Column(nullable = false, length = 10)
    private String estado;
    /** . */
    @Column(nullable = false)
    private Double valor;
    /** . */
    @Column(name = "FECHA_REGISTRO", nullable = false)
    private LocalDateTime fechaRegistro;
    /** . */
    @Column(name = "FECHA_ACTUALIZACION")
    private LocalDateTime fechaActualizacion;

    /**
     * Crea una nueva instancia de la entidad ClaseDocumento.
     */
    public DemoEntidad() {
        super();
    }

    /**
     * Crea una nueva instancia de la clase DemoEntidad
     * @param licencia
     * @param codigo
     */
    public DemoEntidad(Integer licencia, String codigo) {
        this.pk = new DemoEntidadPK(licencia, codigo);
    }

    /**
     * Crea una nueva instancia de la clase DemoEntidad
     * @param licencia
     * @param codigo
     * @param nombre
     * @param valor
     */
    public DemoEntidad(Integer licencia, String codigo, String nombre, Double valor) {
        this(licencia, codigo);
        this.nombre = nombre;
        this.valor = valor;
    }

    /**
     * Obtiene el atributo de clase: "pk"
     * @return el/la pk
     */
    public DemoEntidadPK getPk() {
        return this.pk;
    }

    /**
     * Asigna valor al atributo de clase: "pk"
     * @param pk el/la pk para asignar el valor
     */
    public void setPk(DemoEntidadPK pk) {
        this.pk = pk;
    }

    /**
     * Obtiene el atributo de clase: "nombre"
     * @return el/la nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Asigna valor al atributo de clase: "nombre"
     * @param nombre el/la nombre para asignar el valor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * Obtiene el atributo de clase: "valor"
     * @return el/la valor
     */
    public Double getValor() {
        return this.valor;
    }

    /**
     * Asigna valor al atributo de clase: "valor"
     * @param valor el/la valor para asignar el valor
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Obtiene el atributo de clase: "fechaRegistro"
     * @return el/la fechaRegistro
     */
    public LocalDateTime getFechaRegistro() {
        return this.fechaRegistro;
    }

    /**
     * Asigna valor al atributo de clase: "fechaRegistro"
     * @param fechaRegistro el/la fechaRegistro para asignar el valor
     */
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene el atributo de clase: "fechaActualizacion"
     * @return el/la fechaActualizacion
     */
    public LocalDateTime getFechaActualizacion() {
        return this.fechaActualizacion;
    }

    /**
     * Asigna valor al atributo de clase: "fechaActualizacion"
     * @param fechaActualizacion el/la fechaActualizacion para asignar el valor
     */
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    /**
     * Interceptor para operaciones previas a la creacion del registro.
     */
    @PrePersist
    protected void prePersist() {
        if (this.estado == null) {
            this.estado = "ACTIVO";
        }
        if (this.fechaRegistro == null) {
            this.fechaRegistro = LocalDateTime.now();
        } else {
            this.fechaActualizacion = LocalDateTime.now();
        }
    }

    /**
     * Interceptor para operaciones previas a la actualizacion del registro.
     */
    @PreUpdate
    protected void preUpdate() {
        this.fechaActualizacion = LocalDateTime.now();
    }
}
