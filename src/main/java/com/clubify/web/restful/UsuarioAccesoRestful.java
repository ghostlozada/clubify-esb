package com.clubify.web.restful;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clubify.persistence.modelo.UsuarioAcceso;
import com.clubify.persistence.repo.UsuarioAccesoRepository;
import com.clubify.web.dto.restful.UsuarioAccesoDTO;
import com.clubify.web.exception.EntidadIdMismatchException;
import com.clubify.web.exception.EntidadNotFoundException;

/**
 * Servicio Restful de la entidad 'UsuarioAcceso'.
 * @author Gux Lozada
 */
@RestController
@RequestMapping("/restapi/usuarios")
public class UsuarioAccesoRestful {
    @Autowired
    private UsuarioAccesoRepository usuarioAccesoRepository;

    /**
     * Buscar un usuario por el email.
     * @param correo
     * @return
     */
    @GetMapping("/{correo}")
    public UsuarioAccesoDTO buscarPorCorreo(@PathVariable String correo) {
        if (StringUtils.isBlank(correo)) {
            throw new EntidadIdMismatchException("No existe un usuario relacionado al correo: nulo");
        }
        List<UsuarioAcceso> res = this.usuarioAccesoRepository.findByEmail(correo);
        if (res == null || res.isEmpty()) {
            throw new EntidadNotFoundException("No existe un usuario relacionado al correo: " + correo);
        } else if (res.size() != 1) {
            throw new EntidadNotFoundException("Existe multiples usuarios relacionados al correo: " + correo);
        }
        return new UsuarioAccesoDTO(res);
    }
}
