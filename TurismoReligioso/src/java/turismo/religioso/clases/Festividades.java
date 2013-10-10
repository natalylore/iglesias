/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.clases;

import java.util.Date;

/**
 *
 * @author Fmla Jimenez
 */
public class Festividades {
    private int idFestividades;
    private String nombreFestividad;
    private String descripcion;
    private Date fecha;

    public Festividades() {
    }

    public Festividades(int idFestividades, String nombreFestividad, String descripcion, Date fecha) {
        this.idFestividades = idFestividades;
        this.nombreFestividad = nombreFestividad;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getIdFestividades() {
        return idFestividades;
    }

    public void setIdFestividades(int idFestividades) {
        this.idFestividades = idFestividades;
    }

    public String getNombreFestividad() {
        return nombreFestividad;
    }

    public void setNombreFestividad(String nombreFestividad) {
        this.nombreFestividad = nombreFestividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
