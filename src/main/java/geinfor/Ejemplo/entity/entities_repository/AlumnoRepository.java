package geinfor.Ejemplo.entity.entities_repository;

import geinfor.Ejemplo.entity.entities_extends.AlumnoExtends;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 23:35
 * @project Ejemplo
 * @programmer Stanimir Dobrev
 */
public interface AlumnoRepository extends JpaRepository<AlumnoExtends, String> {
}
