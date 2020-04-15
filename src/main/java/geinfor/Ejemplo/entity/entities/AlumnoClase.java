/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geinfor.Ejemplo.entity.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author stani
 */
@MappedSuperclass
@Table(name = "ALUMNO_CLASE")
@XmlRootElement
public class AlumnoClase implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlumnoClasePK alumnoClasePK;
    @Basic(optional = false)
    @Column(name = "FECHA_ALTA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    public AlumnoClase() {
    }

    public AlumnoClase(AlumnoClasePK alumnoClasePK) {
        this.alumnoClasePK = alumnoClasePK;
    }

    public AlumnoClase(AlumnoClasePK alumnoClasePK, Date fechaAlta) {
        this.alumnoClasePK = alumnoClasePK;
        this.fechaAlta = fechaAlta;
    }

    public AlumnoClase(String dniAlumno, int codigoClase) {
        this.alumnoClasePK = new AlumnoClasePK(dniAlumno, codigoClase);
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alumnoClasePK != null ? alumnoClasePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoClase)) {
            return false;
        }
        AlumnoClase other = (AlumnoClase) object;
        if ((this.alumnoClasePK == null && other.alumnoClasePK != null) || (this.alumnoClasePK != null && !this.alumnoClasePK.equals(other.alumnoClasePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.entities.AlumnoClase[ alumnoClasePK=" + alumnoClasePK + " ]";
    }
    
}
