package geinfor.Ejemplo.services.alumno;

import geinfor.Ejemplo.entity.entities_extends.AlumnoExtends;
import geinfor.Ejemplo.exception.NoFindException;
import geinfor.Ejemplo.models.AlumnoModel;
import org.springframework.http.HttpHeaders;

import java.util.List;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 19:21
 * @project EjemploProyecto SpringBoot
 * @programmer Stanimir Dobrev
 */
public interface AlumnoService {
    AlumnoModel getAlumnoById(String id) throws NoFindException;

    List<AlumnoModel> getAlumnosList(HttpHeaders headers);

    void deleteAlumno(String nif) throws NoFindException;

    void saveOrModifyAlumno(AlumnoExtends alumno) throws NoFindException;
}
