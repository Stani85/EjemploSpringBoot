package geinfor.Ejemplo.services.clase;

import geinfor.Ejemplo.constantes.ConstantesExcepciones;
import geinfor.Ejemplo.entity.entities_extends.ClaseExtends;
import geinfor.Ejemplo.entity.entities_repository.ClaseRepository;
import geinfor.Ejemplo.exception.NoFindException;
import geinfor.Ejemplo.models.ClaseModel;
import geinfor.Ejemplo.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 19:24
 * @project EjemploProyecto SpringBoot
 * @programmer Stanimir Dobrev
 */
@Service("claseService")
public class ClaseServiceImp implements ClaseService {

    @Autowired
    @Qualifier("claseRepository")
    ClaseRepository claseRepository;

    @Override
    @Transactional
    public ClaseModel getClaseById(int id) throws NoFindException {
        ClaseExtends clase;
        try {
            clase = this.claseRepository.findById(id).orElse(null);
            if (clase == null) {
                throw new NoFindException(ConstantesExcepciones.CLASE_NOT_FOUND);
            }
            return ObjectMapperUtils.map(clase, ClaseModel.class);
        } finally {
            clase = null;
        }
    }

    @Override
    public List<ClaseModel> getClaseList(HttpHeaders headers) {
        List<ClaseExtends> clases;
        try {
            clases = this.claseRepository.findAll();
            return ObjectMapperUtils.mapAll(clases, ClaseModel.class);
        } finally {
            clases = null;
        }
    }

    @Override
    public void deleteClase(int id, HttpHeaders headers) throws NoFindException {
        ClaseExtends clase;
        try {
            clase = this.claseRepository.findById(id).orElse(null);
            if (clase == null) {
                throw new NoFindException(ConstantesExcepciones.CLASE_NOT_FOUND);
            }
            this.claseRepository.delete(clase);
        } finally {
            clase = null;
        }
    }

    @Override
    public void saveOrModifyClase(ClaseExtends clase) {
        if(clase.getCodigo() == 0){
            clase.setCodigo(this.claseRepository.findNewId());
        }
        this.claseRepository.save(clase);
    }

}
