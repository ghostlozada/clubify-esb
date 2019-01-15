package com.clubify.web.dto.restful;

import java.io.Serializable;
import java.util.List;

import com.clubify.persistence.modelo.Banner;

/**
 * @author Gux Lozada
 */
public class BannersDTO implements Serializable {
    /** Id por JVM. */
    private static final long serialVersionUID = 6251791510504822873L;
    private List<Banner> banners;

    /**
     * Crea una nueva instancia de la clase BannersDTO
     */
    public BannersDTO() {
        super();
    }

    /**
     * Crea una nueva instancia de la clase BannersDTO
     * @param banners
     */
    public BannersDTO(List<Banner> banners) {
        super();
        this.banners = banners;
    }

    /**
     * Obtiene el atributo de clase: "banners"
     * @return el/la banners
     */
    public List<Banner> getBanners() {
        return this.banners;
    }

    /**
     * Asigna valor al atributo de clase: "banners"
     * @param banners el/la banners para asignar el valor
     */
    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }
}
