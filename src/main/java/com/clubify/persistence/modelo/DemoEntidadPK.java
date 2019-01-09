package com.clubify.persistence.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Demo de clave compuesta de tabla.
 * @author Gux Lozada
 */
@Embeddable
public class DemoEntidadPK implements Serializable {
    /** Id por JVM. */
    private static final long serialVersionUID = 6587416198557507305L;
    /** . */
    @Column(name = "NUM_LICENCIA", nullable = false, length = 10)
    private Integer licencia;
    /** . */
    @Column(nullable = false, length = 15)
    private String codigo;

    /**
     * Crea una nueva instancia de la clase DemoEntidadPK
     */
    public DemoEntidadPK() {
    }

    /**
     * Crea una nueva instancia de la clase DemoEntidadPK
     * @param licencia
     * @param codigo
     */
    public DemoEntidadPK(Integer licencia, String codigo) {
        this.licencia = licencia;
        this.codigo = codigo;
    }

    /**
     * Obtiene el atributo de clase: "licencia"
     * @return el/la licencia
     */
    public Integer getLicencia() {
        return this.licencia;
    }

    /**
     * Asigna valor al atributo de clase: "licencia"
     * @param licencia el/la licencia para asignar el valor
     */
    public void setLicencia(Integer licencia) {
        this.licencia = licencia;
    }

    /**
     * Obtiene el atributo de clase: "codigo"
     * @return el/la codigo
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     * Asigna valor al atributo de clase: "codigo"
     * @param codigo el/la codigo para asignar el valor
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
