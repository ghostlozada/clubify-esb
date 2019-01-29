package com.clubify.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.clubify.persistence.modelo.Noticia;

/**
 * Proxy para operaciones crud de la entidad.
 * @author Gux Lozada.
 */
public interface NoticiaRepository extends CrudRepository<Noticia, Long> {
    /**
     * Todas estado=1 ordenadas por id.
     * @return
     */
    @Query("SELECT u FROM Noticia u ORDER BY u.id")
    List<Noticia> buscarActivas();
}
