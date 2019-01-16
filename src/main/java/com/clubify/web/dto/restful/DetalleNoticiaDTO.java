package com.clubify.web.dto.restful;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.clubify.persistence.modelo.Noticia;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gux Lozada
 */
public class DetalleNoticiaDTO implements Serializable {
    /** Id por JVM. */
    private static final long serialVersionUID = 1833797271353773369L;
    @JsonProperty("DetailNews")
    private List<Noticia> noticias;

    /**
     * Crea una nueva instancia de la clase DetalleNoticiaDTO
     */
    public DetalleNoticiaDTO() {
        super();
    }

    /**
     * Crea una nueva instancia de la clase DetalleNoticiaDTO
     * @param noticia
     */
    public DetalleNoticiaDTO(Noticia noticia) {
        super();
        if (noticia != null) {
            this.noticias = new ArrayList<Noticia>();
            this.noticias.add(noticia);
        }
    }

    /**
     * Obtiene el atributo de clase: "noticias"
     * @return el/la noticias
     */
    public List<Noticia> getNoticias() {
        return this.noticias;
    }

    /**
     * Asigna valor al atributo de clase: "noticias"
     * @param noticias el/la noticias para asignar el valor
     */
    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
}
