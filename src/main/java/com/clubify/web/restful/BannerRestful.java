package com.clubify.web.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clubify.persistence.repo.BannerRepository;
import com.clubify.web.dto.restful.BannersDTO;

/**
 * Servicio Restful de la entidad 'Banner'.
 * @author Gux Lozada
 */
@RestController
@RequestMapping("/restapi/banners")
public class BannerRestful {
    @Autowired
    private BannerRepository bannerRepository;

    /**
     * Obtiene los banners.
     * @return
     */
    @GetMapping
    public BannersDTO todos() {
        return new BannersDTO(this.bannerRepository.ordenadasPorId());
    }
}