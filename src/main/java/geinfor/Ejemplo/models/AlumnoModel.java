package geinfor.Ejemplo.models;

import geinfor.Ejemplo.entity.entities_extends.AlumnoClaseExtends;

import java.util.Date;
import java.util.List;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 22:50
 * @project Ejemplo
 * @programmer Stanimir Dobrev
 */
public class AlumnoModel {

    private String dni;
    private String nombre;
    private Date fechaNacimiento;

    public AlumnoModel() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
