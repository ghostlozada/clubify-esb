package com.clubify.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.clubify.persistence.modelo.Banner;

/**
 * Proxy para operaciones crud de la entidad.
 * @author Gux Lozada.
 */
public interface BannerRepository extends CrudRepository<Banner, Long> {
    /**
     * Todas ordenadas por id.
     * @return
     */
    @Query("SELECT u FROM Banner u order by u.id")
    List<Banner> ordenadasPorId();
}
