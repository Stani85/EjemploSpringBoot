package geinfor.Ejemplo.services.clase;

import geinfor.Ejemplo.entity.entities_extends.ClaseExtends;
import geinfor.Ejemplo.exception.NoFindException;
import geinfor.Ejemplo.models.ClaseModel;
import org.springframework.http.HttpHeaders;

import java.util.List;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 19:23
 * @project EjemploProyecto SpringBoot
 * @programmer Stanimir Dobrev
 */
public interface ClaseService {

    ClaseModel getClaseById(int id) throws NoFindException;

    List<ClaseModel> getClaseList(HttpHeaders headers);

    void deleteClase(int id, HttpHeaders headers) throws NoFindException;

    void saveOrModifyClase(ClaseExtends clase);
}
