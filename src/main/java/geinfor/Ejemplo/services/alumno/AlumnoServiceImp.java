package geinfor.Ejemplo.services.alumno;

import geinfor.Ejemplo.constantes.ConstantesExcepciones;
import geinfor.Ejemplo.entity.entities_extends.AlumnoExtends;
import geinfor.Ejemplo.entity.entities_extends.ClaseExtends;
import geinfor.Ejemplo.entity.entities_repository.AlumnoRepository;
import geinfor.Ejemplo.entity.entities_repository.ClaseRepository;
import geinfor.Ejemplo.exception.NoFindException;
import geinfor.Ejemplo.models.AlumnoModel;
import geinfor.Ejemplo.models.ClaseModel;
import geinfor.Ejemplo.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 19:21
 * @project EjemploProyecto SpringBoot
 * @programmer Stanimir Dobrev
 */
@Service("alumnoService")
public class AlumnoServiceImp implements AlumnoService {

    @Autowired
    @Qualifier("alumnoRepository")
    AlumnoRepository alumnoRepository;

    @Override
    public AlumnoModel getAlumnoById(String id) throws NoFindException {
        AlumnoExtends alumno;
        try {
            alumno = this.alumnoRepository.findById(id).orElse(null);
            if (alumno == null) {
                throw new NoFindException(ConstantesExcepciones.ALUMNO_CLASE_NOT_FOUND);
            }
            return ObjectMapperUtils.map(alumno, AlumnoModel.class);
        } finally {
            alumno = null;
        }
    }

    @Override
    public List<AlumnoModel> getAlumnosList(HttpHeaders headers) {
        List<AlumnoExtends> alumnosList;
        try {
            alumnosList = this.alumnoRepository.findAll();
            return ObjectMapperUtils.mapAll(alumnosList, AlumnoModel.class);
        } finally {
            alumnosList = null;
        }
    }

    @Override
    public void deleteAlumno(String nif) throws NoFindException {
        AlumnoExtends alumno;
        try {
            alumno = this.alumnoRepository.findById(nif).orElse(null);
            if (alumno == null) {
                throw new NoFindException(ConstantesExcepciones.ALUMNO_CLASE_NOT_FOUND);
            }
            this.alumnoRepository.delete(alumno);
        } finally {
            alumno = null;
        }
    }

    @Override
    public void saveOrModifyAlumno(AlumnoExtends alumno) throws NoFindException {
        if (alumno.getDni().equals("")) {
            throw new NoFindException("El nif no puede estar vacio");
        }
        this.alumnoRepository.save(alumno);
    }
}
