package geinfor.Ejemplo.services.alumno_clase;

import geinfor.Ejemplo.exception.NoFindException;
import geinfor.Ejemplo.models.AlumnoClaseModel;
import geinfor.Ejemplo.models.AlumnoClaseSaveModel;
import org.springframework.http.HttpHeaders;

import java.util.List;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 19:23
 * @project EjemploProyecto SpringBoot
 * @programmer Stanimir Dobrev
 */
public interface AlumnoClaseService {

    AlumnoClaseModel getAlumnoClaseById(Integer codigo, String nif) throws NoFindException;

    List<AlumnoClaseModel> getAlumnoClaseList(HttpHeaders headers);

    void deleteAlumnoClase(Integer codigo, String nif) throws NoFindException;

    void saveOrModifyAlumnoClase(AlumnoClaseSaveModel alumnoClase) throws NoFindException;
}
