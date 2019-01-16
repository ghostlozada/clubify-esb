package com.clubify.web.dto.restful;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.clubify.persistence.modelo.Noticia;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gux Lozada
 */
public class NoticiasDTO implements Serializable {
    /** Id por JVM. */
    private static final long serialVersionUID = 5655900483245033623L;
    @JsonProperty("news")
    private List<Noticia> noticias = new ArrayList<>();

    /**
     * Crea una nueva instancia de la clase NoticiasDTO
     */
    public NoticiasDTO() {
        super();
    }

    /**
     * Crea una nueva instancia de la clase NoticiasDTO
     * @param noticias
     */
    public NoticiasDTO(List<Noticia> noticias) {
        super();
        if (noticias != null) {
            this.noticias.addAll(noticias);
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
