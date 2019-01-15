/*
 * Gestorinc S.A.
 * Sistema: Gestor Bot
 * Los contenidos de este archivo son propiedad intelectual de Gestorinc S.A.
 * y se encuentran protegidos por la licencia: "GESTOR FIDUCIA/FONDOS G5".
 * Usted puede encontrar una copia de esta licencia en:
 * http://www.gestorinc.com
 * Copyright 2008-2019 Gestorinc S.A. Todos los derechos reservados.
 */
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
