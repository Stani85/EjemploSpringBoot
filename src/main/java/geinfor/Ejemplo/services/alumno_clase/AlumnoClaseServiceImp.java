package geinfor.Ejemplo.services.alumno_clase;

import geinfor.Ejemplo.entity.entities.AlumnoClasePK;
import geinfor.Ejemplo.entity.entities_extends.AlumnoClaseExtends;
import geinfor.Ejemplo.entity.entities_repository.AlumnoClaseRepository;
import geinfor.Ejemplo.exception.NoFindException;
import geinfor.Ejemplo.models.AlumnoClaseModel;
import geinfor.Ejemplo.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
                throw new NoFindException("No se ha encotrado la clase");
            }
            return ObjectMapperUtils.map(alumnoClase, AlumnoClaseModel.class);
        }  finally {
            alumnoClase = null;
        }
    }

    @Override
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
                throw new NoFindException("No se ha encotrado la clase");
            }
            this.alumnoClaseRepository.delete(alumnoClase);
        } finally {
            alumnoClase = null;
        }
    }

    @Override
    public void saveOrModifyAlumnoClase(AlumnoClaseExtends alumnoClase) {
        if(alumnoClase.getAlumnoClasePK().getCodigoClase() <= 0 && !alumnoClase.getAlumnoClasePK().getDniAlumno().equals("")){

        }
        this.alumnoClaseRepository.save(alumnoClase);
    }
}
