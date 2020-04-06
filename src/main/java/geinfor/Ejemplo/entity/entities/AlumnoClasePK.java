/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geinfor.Ejemplo.entity.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author stani
 */
@Embeddable
public class AlumnoClasePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "DNI_ALUMNO", nullable = false, length = 9)
    private String dniAlumno;
    @Basic(optional = false)
    @Column(name = "CODIGO_CLASE", nullable = false)
    private int codigoClase;

    public AlumnoClasePK() {
    }

    public AlumnoClasePK(String dniAlumno, int codigoClase) {
        this.dniAlumno = dniAlumno;
        this.codigoClase = codigoClase;
    }

    public String getDniAlumno() {
        return dniAlumno;
    }

    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }

    public int getCodigoClase() {
        return codigoClase;
    }

    public void setCodigoClase(int codigoClase) {
        this.codigoClase = codigoClase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dniAlumno != null ? dniAlumno.hashCode() : 0);
        hash += (int) codigoClase;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoClasePK)) {
            return false;
        }
        AlumnoClasePK other = (AlumnoClasePK) object;
        if ((this.dniAlumno == null && other.dniAlumno != null) || (this.dniAlumno != null && !this.dniAlumno.equals(other.dniAlumno))) {
            return false;
        }
        if (this.codigoClase != other.codigoClase) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.entities.AlumnoClasePK[ dniAlumno=" + dniAlumno + ", codigoClase=" + codigoClase + " ]";
    }
    
}
