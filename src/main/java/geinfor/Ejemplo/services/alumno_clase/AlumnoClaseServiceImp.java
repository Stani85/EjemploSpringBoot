package geinfor.Ejemplo.services.alumno_clase;

import geinfor.Ejemplo.constantes.ConstantesExcepciones;
import geinfor.Ejemplo.entity.entities.AlumnoClase;
import geinfor.Ejemplo.entity.entities.AlumnoClasePK;
import geinfor.Ejemplo.entity.entities_extends.AlumnoClaseExtends;
import geinfor.Ejemplo.entity.entities_extends.AlumnoExtends;
import geinfor.Ejemplo.entity.entities_extends.ClaseExtends;
import geinfor.Ejemplo.entity.entities_repository.AlumnoClaseRepository;
import geinfor.Ejemplo.exception.NoFindException;
import geinfor.Ejemplo.models.AlumnoClaseModel;
import geinfor.Ejemplo.models.AlumnoClaseSaveModel;
import geinfor.Ejemplo.services.alumno.AlumnoService;
import geinfor.Ejemplo.services.clase.ClaseService;
import geinfor.Ejemplo.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 19:23
 * @project EjemploProyecto SpringBoot
 * @programmer Stanimir Dobrev
 */
@Service("alumnoClaseService")
public class AlumnoClaseServiceImp implements AlumnoClaseService {

    @Autowired
    @Qualifier("alumnoClaseRepository")
    private AlumnoClaseRepository alumnoClaseRepository;

    @Autowired
    @Qualifier("alumnoService")
    AlumnoService alumnoService;

    @Autowired
    @Qualifier("claseService")
    ClaseService claseService;

    @Override
    @Transactional
    public AlumnoClaseModel getAlumnoClaseById(Integer codigo, String nif) throws NoFindException {
        AlumnoClaseExtends alumnoClase;
        AlumnoClasePK alumnoClasePK;
        try {
            alumnoClasePK = new AlumnoClasePK();
            alumnoClasePK.setCodigoClase(codigo);
            alumnoClasePK.setDniAlumno(nif);
            alumnoClase = this.alumnoClaseRepository.findById(alumnoClasePK).orElse(null);
            if (alumnoClase == null) {
                throw new NoFindException(ConstantesExcepciones.ALUMNO_CLASE_NOT_FOUND);
            }
            return ObjectMapperUtils.map(alumnoClase, AlumnoClaseModel.class);
        } finally {
            alumnoClase = null;
        }
    }

    @Override
    @Transactional
    public List<AlumnoClaseModel> getAlumnoClaseList(HttpHeaders headers) {
        List<AlumnoClaseExtends> alumnoClaseList;
        try {
            alumnoClaseList = this.alumnoClaseRepository.findAll();
            return ObjectMapperUtils.mapAll(alumnoClaseList, AlumnoClaseModel.class);
        } finally {
            alumnoClaseList = null;
        }
    }

    @Override
    public void deleteAlumnoClase(Integer codigo, String nif) throws NoFindException {
        AlumnoClaseExtends alumnoClase;
        AlumnoClasePK alumnoClasePK;
        try {
            alumnoClasePK = new AlumnoClasePK();
            alumnoClasePK.setCodigoClase(codigo);
            alumnoClasePK.setDniAlumno(nif);
            alumnoClase = this.alumnoClaseRepository.findById(alumnoClasePK).orElse(null);
            if (alumnoClase == null) {
                throw new NoFindException(ConstantesExcepciones.ALUMNO_NOT_FOUND);
            }
            this.alumnoClaseRepository.delete(alumnoClase);
        } finally {
            alumnoClase = null;
        }
    }

    @Override
    public void saveOrModifyAlumnoClase(AlumnoClaseSaveModel alumnoClase) throws NoFindException {
        AlumnoClaseExtends alumnoClaseToSave;
        Date date;
        try {
            alumnoClaseToSave = new AlumnoClaseExtends();
            alumnoClaseToSave.setAlumno(ObjectMapperUtils.map(this.alumnoService.getAlumnoById(alumnoClase.getDniAlumno()), AlumnoExtends.class));
            alumnoClaseToSave.setClase(ObjectMapperUtils.map(this.claseService.getClaseById(alumnoClase.getCodigoClase()), ClaseExtends.class));
            date = new Date(Calendar.getInstance().getTime().getTime());
            alumnoClaseToSave.setFechaAlta(date);
            alumnoClaseToSave.setAlumnoClasePK(ObjectMapperUtils.map(alumnoClase, AlumnoClasePK.class));
            this.alumnoClaseRepository.save(alumnoClaseToSave);
        } finally {
            date = null;
            alumnoClaseToSave = null;
        }
    }
}
