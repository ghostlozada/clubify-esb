package com.clubify.web.restful.firebase;

import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clubify.firebase.ActualizacionClaveUsuarioUtil;

/**
 * Servicio Restful para actualizar la clave del usuario.
 * @author Gux Lozada
 */
@RestController
@RequestMapping("/restapi/users")
public class UsersRestful {
    final static Logger LOG = Logger.getLogger(UsersRestful.class.getName());

    /**
     * @param queri
     * @return
     */
    @GetMapping("/query/{queri}")
    public String getQuery(@PathVariable String queri) {
        LOG.info("++++ Restful Prueba: /query/" + queri);
        String consulta = StringUtils.replace(queri, "00000", "?");
        consulta = StringUtils.replace(consulta, "11111", "/");
        consulta = StringUtils.replace(consulta, "UUU", "%22");
        // https://fir-gux-push.firebaseio.com/users.json?orderBy=%22email%22&equalTo=%22gustavo@gmail.com%22]]
        return ActualizacionClaveUsuarioUtil.consultar(consulta);
    }

    /**
     * @param correo
     * @return
     */
    @GetMapping("/consulta/{correo}")
    public String getConsulta(@PathVariable String correo) {
        LOG.info("++++ Restful Prueba: /consulta/" + correo);
        // https://fir-gux-push.firebaseio.com/users.json?orderBy=%22email%22&equalTo=%22gustavo@gmail.com%22]]
        try {
            return ActualizacionClaveUsuarioUtil.consultarPorCorreo(correo);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * @param correo
     * @param nuevaClave
     * @return
     */
    @GetMapping("/actualizarclave/{correo}/{nuevaClave}")
    public String getActualizarClave(@PathVariable String correo, @PathVariable String nuevaClave) {
        LOG.info("++++ Restful Prueba: /actualizarclave/" + StringUtils.defaultIfBlank(correo, "nulo") + "/"
                + StringUtils.defaultIfBlank(nuevaClave, "nulo"));
        try {
            String usuarioJson = ActualizacionClaveUsuarioUtil.consultarPorCorreo(correo);
            ActualizacionClaveUsuarioUtil.actualizarClave(usuarioJson, nuevaClave);
            return "OK";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
