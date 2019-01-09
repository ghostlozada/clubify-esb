package com.clubify.web.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clubify.persistence.modelo.DemoEntidad;
import com.clubify.persistence.modelo.DemoEntidadPK;
import com.clubify.persistence.repo.DemoEntidadRepository;
import com.clubify.web.exception.EntidadIdMismatchException;
import com.clubify.web.exception.EntidadNotFoundException;

/**
 * Servicio Restful de la entidad demo.
 * @author Gux Lozada
 */
@RestController
@RequestMapping("/clubify/api/tablademo")
public class DemoEntidadRestful {
    @Autowired
    private DemoEntidadRepository demoEntidadRepository;

    @GetMapping
    public Iterable findAll() {
        return this.demoEntidadRepository.findAll();
    }

    @GetMapping("/licencia/{numLicencia}")
    public List findByTitle(@PathVariable String numLicencia) {
        return this.demoEntidadRepository.buscarPorLicencia(Integer.valueOf(numLicencia));
    }

    @GetMapping("/codigo/{codigo}")
    public DemoEntidad findOne(@PathVariable String codigo) {
        return this.demoEntidadRepository.findByPk(new DemoEntidadPK(1, codigo)).orElseThrow(EntidadNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DemoEntidad create(@RequestBody DemoEntidad demoEntidad) {
        return this.demoEntidadRepository.save(demoEntidad);
    }

    @DeleteMapping("/{licencia}/{codigo}")
    public void delete(@PathVariable String licencia, @PathVariable String codigo) {
        DemoEntidadPK pk = new DemoEntidadPK(Integer.valueOf(licencia), codigo);
        this.demoEntidadRepository.findByPk(pk).orElseThrow(EntidadNotFoundException::new);
        this.demoEntidadRepository.delete(new DemoEntidad(pk.getLicencia(), codigo));
    }

    @PutMapping("/{licencia}/{codigo}")
    public DemoEntidad update(@RequestBody DemoEntidad demoEntidad, @PathVariable String licencia, @PathVariable String codigo) {
        DemoEntidadPK pk = new DemoEntidadPK(Integer.valueOf(licencia), codigo);
        if (!demoEntidad.getPk().equals(pk)) {
            throw new EntidadIdMismatchException();
        }
        this.demoEntidadRepository.findByPk(pk).orElseThrow(EntidadNotFoundException::new);
        return this.demoEntidadRepository.save(demoEntidad);
    }

    @PutMapping("/leido/{licencia}/{codigo}")
    public DemoEntidad updateEstado(@PathVariable String licencia, @PathVariable String codigo) {
        DemoEntidad registro = this.demoEntidadRepository.findByPk(new DemoEntidadPK(1, codigo))
                .orElseThrow(EntidadNotFoundException::new);
        registro.setEstado("LEIDO");
        return this.demoEntidadRepository.save(registro);
    }
}
