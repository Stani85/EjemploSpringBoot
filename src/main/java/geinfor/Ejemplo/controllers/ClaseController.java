package geinfor.Ejemplo.controllers;

import geinfor.Ejemplo.entity.entities_extends.ClaseExtends;
import geinfor.Ejemplo.exception.NoFindException;
import geinfor.Ejemplo.models.ClaseModel;
import geinfor.Ejemplo.services.clase.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 19:19
 * @project EjemploProyecto SpringBoot
 * @programmer Stanimir Dobrev
 */
@RestController
@RequestMapping("/protected/clase")
public class ClaseController {

    @Autowired
    @Qualifier("claseService")
    ClaseService claseService;

    @GetMapping(value = "/{id}")
    public ClaseModel getClasePorId(@PathVariable("id") int id) throws NoFindException {
        return this.claseService.getClasePorId(id);
    }

    @GetMapping(value = "/")
    public List<ClaseModel> getUnassociatedQueryList(@RequestHeader HttpHeaders headers) {
        return this.claseService.getClaseList(headers);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteClase(@PathVariable int id, @RequestHeader HttpHeaders headers) throws NoFindException {
        this.claseService.deleteClase(id, headers);
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOrUpdateClase(@RequestBody ClaseExtends clase) {
        this.claseService.saveOrModifyClase(clase);
    }

}
