package com.clubify.web.restful;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clubify.firebase.EnvioNotificacionPushUtil;
import com.clubify.persistence.modelo.Notificacion;
import com.clubify.persistence.modelo.NotificacionEnvio;
import com.clubify.persistence.repo.NotificacionEnvioRepository;
import com.clubify.persistence.repo.NotificacionRepository;
import com.clubify.web.exception.EntidadNotFoundException;

/**
 * Servicio Restful de la entidad 'Notificacion'.
 * @author Gux Lozada
 */
@RestController
@RequestMapping("/restapi/notificacionespush")
public class NotificacionPushRestful {
    final static Logger LOG = Logger.getLogger(NotificacionPushRestful.class.getName());
    final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    final static int bloque = 30;
    final static int numMaxPaginas = 10;// 100
    @Autowired
    private NotificacionRepository notificacionRepository;
    @Autowired
    private NotificacionEnvioRepository notificacionEnvioRepository;
    private boolean procesando = false;

    /**
     * Envia las notificaciones push.
     * @param destinatario
     * @return
     */
    @GetMapping("/enviar/{destinatario}")
    public String getEnviorPorDestinatario(@PathVariable String destinatario) {
        final StringBuilder respuesta = new StringBuilder("Cod_notificacion: ");
        this.notificacionEnvioRepository.findByDestinatario(destinatario, PageRequest.of(0, bloque, Sort.by("codNotificacion")))
                .forEach(n -> {
                    try {
                        boolean res = EnvioNotificacionPushUtil.envioIndividual(n);
                        respuesta.append(n.getCodNotificacion()).append(" ");
                        if (res) {
                            Notificacion registro = this.notificacionRepository.findById(Long.valueOf(n.getCodNotificacion()))
                                    .orElseThrow(EntidadNotFoundException::new);
                            registro.setEnviado("2");
                            this.notificacionRepository.save(registro);
                        }
                    } catch (Exception e) {
                        LOG.log(Level.SEVERE, e.getMessage(), e);
                    }
                });
        return respuesta.toString();
    }

    /**
     * Envia las notificaciones push.
     * @param destinatario
     * @return
     */
    @GetMapping("/enviomasivo")
    public String getEnvioMasivo() {
        String res = "NINGUNO";
        if (this.procesando) {
            res = "Envio masivo de notificaciones push en proceso:" + LocalDateTime.now().format(formatter);
            LOG.log(Level.INFO, res);
            return res;
        }
        LocalDateTime inicio = LocalDateTime.now();
        this.procesando = true;
        int numPagina = 0;
        int count = 0;
        Pageable paginacion = null;
        Page<NotificacionEnvio> siguiente = null;
        do {
            paginacion = PageRequest.of(0, bloque, Sort.by("codNotificacion"));
            siguiente = this.notificacionEnvioRepository.findAll(paginacion);
            //// TEST: siguiente = this.notificacionEnvioRepository.findByDestinatario("gustavorlozada@gmail.com", paginacion);
            if (siguiente == null || siguiente.isEmpty()) {
                break;
            }
            count += siguiente.getNumberOfElements();
            LOG.log(Level.INFO,
                    MessageFormat.format(
                            "+++++ Numero Pagina={0}; tamanio={1}; NumberOfElements{2}; TotalElements{3}; TotalPages{4}",
                            paginacion.getPageNumber(), paginacion.getPageSize(), siguiente.getNumberOfElements(),
                            siguiente.getTotalElements(), siguiente.getTotalPages()));
            EnvioNotificacionPushUtil.envioMasivo(siguiente.getContent()).forEach(codNtfEnviado -> {
                try {
                    Notificacion registro = this.notificacionRepository.findById(codNtfEnviado)
                            .orElseThrow(EntidadNotFoundException::new);
                    registro.setEnviado("2");
                    this.notificacionRepository.save(registro);
                } catch (Exception e) {
                    LOG.log(Level.SEVERE,
                            MessageFormat.format("Error en el ennvio de la notificacion: codNotificacion={0}; message={2} ",
                                    codNtfEnviado, e.getMessage()),
                            e);
                }
            });
            numPagina++;
        } while (this.procesando && numPagina < numMaxPaginas);
        this.procesando = false;
        return MessageFormat.format(
                "Envio masivo de notificaciones push finalizado.  # Notificaciones={0}; hora inicio={1};hora fin={2} ", count,
                inicio.format(formatter), LocalDateTime.now().format(formatter));
    }
}
