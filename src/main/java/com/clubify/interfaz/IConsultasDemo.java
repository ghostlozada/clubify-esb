package com.clubify.interfaz;

import java.util.List;

import com.clubify.persistence.modelo.DemoEntidad;
import com.clubify.persistence.modelo.DemoEntidadPK;

/**
 * Consultas personalizadas a la entidad demo.
 * @author Gux Lozada
 */
public interface IConsultasDemo {
    /**
     * Busca registros por licencia
     * @param licencia
     * @return
     */
    List<DemoEntidad> buscarPorLicencia(Integer licencia);

    /**
     * Obtiene las claves primarias de todos los registros.
     * @return
     */
    List<DemoEntidadPK> buscarTodos();
}
