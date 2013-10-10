/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.clases;

/**
 *
 * @author Fmla Jimenez
 */
public class Precios {
    private int idPrecio;
    private String descripcion;
    private float precio;

    public Precios() {
    }

    public Precios(int idPrecio, String descripcion, float precio) {
        this.idPrecio = idPrecio;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(int idPrecio) {
        this.idPrecio = idPrecio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
