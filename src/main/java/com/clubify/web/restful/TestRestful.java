package com.clubify.web.restful;

import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clubify.firebase.FirebaseTestUtil;

/**
 * Servicio Restful para actualizar la clave del usuario.
 * @author Gux Lozada
 */
@RestController
@RequestMapping("/restapi/test")
public class TestRestful {
    final static Logger LOG = Logger.getLogger(TestRestful.class.getName());

    @GetMapping("/uno/{alias}")
    public String getUno(@PathVariable String alias) {
        LOG.severe("++++ Restful Prueba: /uno/" + alias);
        return FirebaseTestUtil.uno(alias);
    }

    @GetMapping("/dos/{alias}")
    public String getDos(@PathVariable String alias) {
        LOG.severe("++++ Restful Prueba: /dos/" + alias);
        return FirebaseTestUtil.dos(alias);
    }

    @GetMapping("/tres")
    public String getTres() {
        LOG.severe("++++ Restful Prueba: /tres/");
        return FirebaseTestUtil.tres();
    }

    @GetMapping("/cuatro")
    public String getCuatro() {
        LOG.severe("++++ Restful Prueba: /cuatro/");
        return FirebaseTestUtil.cuatro();
    }
    // @GetMapping("/consulta/{queri}")
    // public String getConsulta(@PathVariable String queri) {
    // LOG.severe("++++ Restful Prueba: /consulta/" + queri);
    // String consulta = StringUtils.replace(queri, "00000", "?");
    // consulta = StringUtils.replace(consulta, "11111", "/");
    // consulta = StringUtils.replace(consulta, "UUU", "%22");
    // return FirebaseTestUtil.consultar(consulta);
    // }
    //
    // @GetMapping("/consulta2/{queri}")
    // public String getConsulta2(@PathVariable String queri) {
    // LOG.severe("++++ Restful Prueba: /consulta2/" + queri);
    // String consulta = StringUtils.replace(queri, "00000", "?");
    // consulta = StringUtils.replace(consulta, "11111", "/");
    // consulta = StringUtils.replace(consulta, "UUU", "%22");
    // return FirebaseTestUtil.consultar2(consulta);
    // }

    /////////////////////////////////////////////////////////////////
    /**
     * @param queri
     * @return
     */
    @GetMapping("/query/{queri}")
    public String getQuery(@PathVariable String queri) {
        LOG.severe("++++ Restful Prueba: /query/" + queri);
        String consulta = StringUtils.replace(queri, "00000", "?");
        consulta = StringUtils.replace(consulta, "11111", "/");
        consulta = StringUtils.replace(consulta, "UUU", "%22");
        // https://fir-gux-push.firebaseio.com/users.json?orderBy=%22email%22&equalTo=%22gustavo@gmail.com%22]]
        return FirebaseTestUtil.consultar(consulta);
    }

    /**
     * @param correo
     * @return
     */
    @GetMapping("/consulta/{correo}")
    public String getConsulta(@PathVariable String correo) {
        LOG.severe("++++ Restful Prueba: /consulta/" + correo);
        // https://fir-gux-push.firebaseio.com/users.json?orderBy=%22email%22&equalTo=%22gustavo@gmail.com%22]]
        try {
            return FirebaseTestUtil.consultarPorCorreo(correo);
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
        LOG.severe("++++ Restful Prueba: /actualizarclave/" + StringUtils.defaultIfBlank(correo, "nulo") + "/"
                + StringUtils.defaultIfBlank(nuevaClave, "nulo"));
        try {
            String usuarioJson = FirebaseTestUtil.consultarPorCorreo(correo);
            FirebaseTestUtil.actualizarClave(usuarioJson, nuevaClave);
            return "OK";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
