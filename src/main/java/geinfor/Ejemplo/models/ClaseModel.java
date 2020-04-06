package geinfor.Ejemplo.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author Geinfor S.L.
 * @created 05/04/2020 - 22:53
 * @project Ejemplo
 * @programmer Stanimir Dobrev
 */
public class ClaseModel {

    private Integer codigo;
    private String nombre;

    public ClaseModel() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
