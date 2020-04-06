package geinfor.Ejemplo.entity.entities_repository;

import geinfor.Ejemplo.entity.entities.AlumnoClasePK;
import geinfor.Ejemplo.entity.entities_extends.AlumnoClaseExtends;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 23:34
 * @project Ejemplo
 * @programmer Stanimir Dobrev
 */
public interface AlumnoClaseRepository extends JpaRepository<AlumnoClaseExtends, AlumnoClasePK> {

}
