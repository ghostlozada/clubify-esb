package com.clubify.web.dto.restful;

import java.io.Serializable;
import java.util.List;

import com.clubify.persistence.modelo.UsuarioAcceso;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gux Lozada
 */
public class UsuarioAccesoDTO implements Serializable {
    /** Id por JVM. */
    private static final long serialVersionUID = 5103026936638656857L;
    @JsonProperty("user")
    private List<UsuarioAcceso> usuarios;

    /**
     * Crea una nueva instancia de la clase UsuarioAccesoDTO
     */
    public UsuarioAccesoDTO() {
        super();
    }

    /**
     * Crea una nueva instancia de la clase UsuarioAccesoDTO
     * @param usuarios
     */
    public UsuarioAccesoDTO(List<UsuarioAcceso> usuarios) {
        super();
        this.usuarios = usuarios;
    }

    /**
     * Obtiene el atributo de clase: "usuarios"
     * @return el/la usuarios
     */
    public List<UsuarioAcceso> getUsuarios() {
        return this.usuarios;
    }

    /**
     * Asigna valor al atributo de clase: "usuarios"
     * @param usuarios el/la usuarios para asignar el valor
     */
    public void setUsuarios(List<UsuarioAcceso> usuarios) {
        this.usuarios = usuarios;
    }
}
