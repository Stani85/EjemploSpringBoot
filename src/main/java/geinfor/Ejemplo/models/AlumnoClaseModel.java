package geinfor.Ejemplo.models;

import geinfor.Ejemplo.entity.entities.AlumnoClasePK;
import geinfor.Ejemplo.entity.entities_extends.AlumnoExtends;
import geinfor.Ejemplo.entity.entities_extends.ClaseExtends;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 22:51
 * @project Ejemplo
 * @programmer Stanimir Dobrev
 */
public class AlumnoClaseModel {

    protected AlumnoClasePK alumnoClasePK;
    private Date fechaAlta;
    private AlumnoModel alumno;
    private ClaseModel clase;

    public AlumnoClaseModel() {
    }

    public AlumnoClasePK getAlumnoClasePK() {
        return alumnoClasePK;
    }

    public void setAlumnoClasePK(AlumnoClasePK alumnoClasePK) {
        this.alumnoClasePK = alumnoClasePK;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public AlumnoModel getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoModel alumno) {
        this.alumno = alumno;
    }

    public ClaseModel getClase() {
        return clase;
    }

    public void setClase(ClaseModel clase) {
        this.clase = clase;
    }
}
