package geinfor.Ejemplo.controllers;

import geinfor.Ejemplo.entity.entities_extends.AlumnoExtends;
import geinfor.Ejemplo.exception.NoFindException;
import geinfor.Ejemplo.models.AlumnoModel;
import geinfor.Ejemplo.services.alumno.AlumnoService;
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
@RequestMapping("/protected/alumno")
public class AlumnoController {

    @Autowired
    @Qualifier("alumnoService")
    private AlumnoService alumnoService;

    @GetMapping(value = "/{nif}")
    public AlumnoModel getAlumno(@PathVariable("nif") String nif) throws NoFindException {
        return this.alumnoService.getAlumnoById(new String(Base64.getDecoder().decode(nif)));
    }

    @GetMapping(value = "/")
    public List<AlumnoModel> getAlumnoList(@RequestHeader HttpHeaders headers) throws NoFindException {
        return this.alumnoService.getAlumnosList(headers);
    }

    @DeleteMapping(value = "/{nif}")
    public void deleteAlumno(@PathVariable String nif) throws NoFindException {
        this.alumnoService.deleteAlumno(new String(Base64.getDecoder().decode(nif)));
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOrUpdateAlumno(@RequestBody AlumnoExtends alumno) throws NoFindException {
        this.alumnoService.saveOrModifyAlumno(alumno);
    }

}
