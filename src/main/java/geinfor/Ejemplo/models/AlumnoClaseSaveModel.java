package geinfor.Ejemplo.models;

import javax.persistence.Basic;
import javax.persistence.Column;

/**
 * @author Geinfor S.L.
 * @created 06/04/2020 - 20:51
 * @project Ejemplo
 * @programmer Stanimir Dobrev
 */
public class AlumnoClaseSaveModel {

    private String dniAlumno;
    private int codigoClase;

    public AlumnoClaseSaveModel() {
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
}
