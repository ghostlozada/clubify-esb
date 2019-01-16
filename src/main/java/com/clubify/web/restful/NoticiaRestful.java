package com.clubify.web.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clubify.persistence.modelo.Noticia;
import com.clubify.persistence.repo.NoticiaRepository;
import com.clubify.web.dto.restful.DetalleNoticiaDTO;
import com.clubify.web.dto.restful.NoticiasDTO;
import com.clubify.web.exception.EntidadNotFoundException;

/**
 * Servicio Restful de la entidad 'Noticia'.
 * @author Gux Lozada
 */
@RestController
@RequestMapping("/restapi/noticias")
public class NoticiaRestful {
    @Autowired
    private NoticiaRepository noticiaRepository;

    /**
     * Obtiene las noticias en estado=1 (Activas).
     * @return
     */
    @GetMapping
    public NoticiasDTO activas() {
        return new NoticiasDTO(this.noticiaRepository.buscarActivas());
    }

    /**
     * Obtiene la noticia relacionada al 'id'.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public DetalleNoticiaDTO buscarPorId(@PathVariable String id) {
        Noticia res = this.noticiaRepository.findById(Long.valueOf(id)).orElseThrow(EntidadNotFoundException::new);
        return new DetalleNoticiaDTO(res);
    }
}
