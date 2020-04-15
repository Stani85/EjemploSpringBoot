package geinfor.Ejemplo.entity.entities_extends;

import geinfor.Ejemplo.entity.entities.Alumno;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 19:41
 * @project EjemploProyecto SpringBoot
 * @programmer Stanimir Dobrev
 */

@Entity
@Table(name = "ALUMNO")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "AlumnoExtends.findAll", query = "SELECT a FROM AlumnoExtends a")
        , @NamedQuery(name = "AlumnoExtends.findByDni", query = "SELECT a FROM AlumnoExtends a WHERE a.dni = :dni")
        , @NamedQuery(name = "AlumnoExtends.findByNombre", query = "SELECT a FROM AlumnoExtends a WHERE a.nombre = :nombre")
        , @NamedQuery(name = "AlumnoExtends.findByFechaNacimiento", query = "SELECT a FROM AlumnoExtends a WHERE a.fechaNacimiento = :fechaNacimiento")})
public class AlumnoExtends extends Alumno implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno", fetch = FetchType.LAZY)
    private List<AlumnoClaseExtends> alumnoClaseList;

    @XmlTransient
    public List<AlumnoClaseExtends> getAlumnoClaseList() {
        return alumnoClaseList;
    }

    public void setAlumnoClaseList(List<AlumnoClaseExtends> alumnoClaseList) {
        this.alumnoClaseList = alumnoClaseList;
    }




}
