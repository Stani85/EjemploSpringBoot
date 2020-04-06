package geinfor.Ejemplo.controllers;

import geinfor.Ejemplo.entity.entities.AlumnoClasePK;
import geinfor.Ejemplo.entity.entities_extends.AlumnoClaseExtends;
import geinfor.Ejemplo.exception.NoFindException;
import geinfor.Ejemplo.models.AlumnoClaseModel;
import geinfor.Ejemplo.services.alumno_clase.AlumnoClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 19:19
 * @project EjemploProyecto SpringBoot
 * @programmer Stanimir Dobrev
 */
@RestController
@RequestMapping("/protected/alumno-clase")
public class AlumnoClaseController {

    @Autowired
    @Qualifier("alumnoClaseService")
    AlumnoClaseService alumnoClaseService;

    @GetMapping(value = "/{codigoClase}/{nifAlumnoBase64}")
    public AlumnoClaseModel getAlumnoClase(@PathVariable("codigoClase") Integer codigo, @PathVariable("nifAlumnoBase64") String nif) throws NoFindException {
        return this.alumnoClaseService.getAlumnoClaseById(codigo, new String(Base64.getDecoder().decode(nif)));
    }

    @GetMapping(value = "/")
    public List<AlumnoClaseModel> getAlumnoClaseList(@RequestHeader HttpHeaders headers) throws NoFindException {
        return this.alumnoClaseService.getAlumnoClaseList(headers);
    }

    @DeleteMapping(value = "/{codigoClase}/{nifAlumnoBase64}")
    public void deleteAlumnoClase(@PathVariable("codigoClase") Integer codigo, @PathVariable("nifAlumnoBase64") String nif) throws NoFindException{
        this.alumnoClaseService.deleteAlumnoClase(codigo, new String(Base64.getDecoder().decode(nif)));
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOrUpdateAlumnoClase(@RequestBody AlumnoClaseExtends alumnoClase)  {
        this.alumnoClaseService.saveOrModifyAlumnoClase(alumnoClase);
    }

}
