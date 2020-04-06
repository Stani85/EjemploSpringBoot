package geinfor.Ejemplo.entity.entities_extends;


import geinfor.Ejemplo.entity.entities.Clase;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**ó
 * @author Geinfor S.L.
 * @created 05/04/2020 - 19:41
 * @project EjemploProyecto SpringBoot
 * @programmer Stanimir Dobrev
 */
@Entity
@Table(name = "CLASE")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ClaseExtends.findAll", query = "SELECT c FROM ClaseExtends c")
        , @NamedQuery(name = "ClaseExtends.findByCodigo", query = "SELECT c FROM ClaseExtends c WHERE c.codigo = :codigo")
        , @NamedQuery(name = "ClaseExtends.findByNombre", query = "SELECT c FROM ClaseExtends c WHERE c.nombre = :nombre")})
public class ClaseExtends extends Clase implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clase", fetch = FetchType.LAZY)
    private List<AlumnoClaseExtends> alumnoClaseList;

    @XmlTransient
    public List<AlumnoClaseExtends> getAlumnoClaseList() {
        return alumnoClaseList;
    }

    public void setAlumnoClaseList(List<AlumnoClaseExtends> alumnoClaseList) {
        this.alumnoClaseList = alumnoClaseList;
    }

}
