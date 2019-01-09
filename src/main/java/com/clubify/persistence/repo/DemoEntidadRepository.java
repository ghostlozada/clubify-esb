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
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.clubify.persistence.modelo.DemoEntidad;
import com.clubify.persistence.modelo.DemoEntidadPK;

/**
 * Proxy para operaciones crud de la entidad.
 * @author Gux Lozada.
 */
public interface DemoEntidadRepository extends CrudRepository<DemoEntidad, Long> {
    /**
     * Consulta por nombre.
     * @param nombre
     * @return
     */
    List<DemoEntidad> findByNombre(String nombre);

    /**
     * Consulta por clave primaria compuesta.
     * @param pk
     * @return
     */
    Optional<DemoEntidad> findByPk(DemoEntidadPK pk);

    /**
     * Busqueda por licencia.
     * @param licencia
     * @return
     */
    @Query("SELECT u FROM DemoEntidad u WHERE u.pk.licencia = :licencia order by u.pk.codigo")
    List<DemoEntidad> buscarPorLicencia(@Param("licencia") Integer licencia);

    /**
     * Actualiza el estado
     * @param licencia
     * @param codigo
     * @param estado
     * @return
     */
    @Modifying
    @Query("update DemoEntidad u set u.estado = :estado where u.pk.licencia = :licencia and u.pk.codigo = :codigo")
    int actualizarEstado(@Param("licencia") Integer licencia, @Param("codigo") String codigo, @Param("estado") String estado);
    // @Modifying
    // @Query("update DemoEntidad u set u.estado = :estado, u.fechaActualizacion = :fechaActual where u.pk.licencia = :licencia
    // and u.pk.codigo = :codigo")
    // int actualizarEstado(@Param("licencia") Integer licencia, @Param("codigo") String codigo, @Param("estado") String estado,
    // @Param("fechaActual") Date fechaActual);
}
