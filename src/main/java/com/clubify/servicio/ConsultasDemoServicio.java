package com.clubify.servicio;

import java.util.List;

import com.clubify.interfaz.IConsultasDemo;
import com.clubify.persistence.modelo.DemoEntidad;
import com.clubify.persistence.modelo.DemoEntidadPK;

/**
 * Consultas personalizadas a la entidad demo.
 * @author Gux Lozada
 */
// @Service
public class ConsultasDemoServicio implements IConsultasDemo {
    // @Autowired
    // private DemoEntidadRepository demoEntidadRepository;
    /**
     * {@inheritDoc}
     */
    @Override
    public List<DemoEntidad> buscarPorLicencia(Integer licencia) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DemoEntidadPK> buscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }
}
