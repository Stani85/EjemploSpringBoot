package geinfor.Ejemplo.entity.entities_extends;


import geinfor.Ejemplo.entity.entities.AlumnoClase;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 19:41ó
 * @project EjemploProyecto SpringBoot
 * @programmer Stanimir Dobrev
 */
@Entity
@Table(name = "ALUMNO_CLASE")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "AlumnoClaseExtends.findAll", query = "SELECT a FROM AlumnoClaseExtends a")
        , @NamedQuery(name = "AlumnoClaseExtends.findByDniAlumno", query = "SELECT a FROM AlumnoClaseExtends a WHERE a.alumnoClasePK.dniAlumno = :dniAlumno")
        , @NamedQuery(name = "AlumnoClaseExtends.findByCodigoClase", query = "SELECT a FROM AlumnoClaseExtends a WHERE a.alumnoClasePK.codigoClase = :codigoClase")
        , @NamedQuery(name = "AlumnoClaseExtends.findByFechaAlta", query = "SELECT a FROM AlumnoClaseExtends a WHERE a.fechaAlta = :fechaAlta")})
public class AlumnoClaseExtends extends AlumnoClase implements Serializable {

    @JoinColumn(name = "DNI_ALUMNO", referencedColumnName = "DNI", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AlumnoExtends alumno;
    @JoinColumn(name = "CODIGO_CLASE", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClaseExtends clase;

    public AlumnoExtends getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoExtends alumno) {
        this.alumno = alumno;
    }

    public ClaseExtends getClase() {
        return clase;
    }

    public void setClase(ClaseExtends clase) {
        this.clase = clase;
    }
}
