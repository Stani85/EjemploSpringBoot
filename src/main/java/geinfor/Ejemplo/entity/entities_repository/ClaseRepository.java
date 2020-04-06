package geinfor.Ejemplo.entity.entities_repository;

import geinfor.Ejemplo.entity.entities_extends.ClaseExtends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 22:46
 * @project Ejemplo
 * @programmer Stanimir Dobrev
 */
@Repository("claseRepository")
public interface ClaseRepository  extends JpaRepository<ClaseExtends, Integer> {

    @Query("select coalesce(max(codigo),0)+1 from ClaseExtends")
    int findNewId();

}
