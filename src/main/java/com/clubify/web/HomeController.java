package com.clubify.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.clubify.persistence.repo.NotificacionEnvioRepository;

/**
 * Conntrolador de la pagina home.html
 * @author Gux Lozada
 */
@Controller
public class HomeController {
    /** Proxy crud de la entidad demo. */
    @Autowired
    private NotificacionEnvioRepository notificacionEnvioRepository;
    /** Variable con el nombre de la aplicacion. */
    @Value("${spring.application.name}")
    String appNombre;
    /// ** Variable con el numero de registros de la tabla demo. */
    // int numeroRegistros;

    /**
     * Servlet mapping.
     * @param model
     * @return
     */
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("nombreApp", this.appNombre);
        model.addAttribute("numeroRegistros", this.notificacionEnvioRepository.count());
        return "home";
    }
}
