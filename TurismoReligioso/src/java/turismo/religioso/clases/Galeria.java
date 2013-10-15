/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.clases;

import java.awt.Image;

/**
 *
 * @author Checho
 */
public class Galeria {
    private int idGaleria;
    private String descripcion;
    private Image imagen;

    public Galeria() {
    }

    public Galeria(int idGaleria, String descripcion) {
        this.idGaleria = idGaleria;
        this.descripcion = descripcion;
    }

    public Galeria(int idGaleria, String descripcion, Image imagen) {
        this.idGaleria = idGaleria;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public int getIdGaleria() {
        return idGaleria;
    }

    public void setIdGaleria(int idGaleria) {
        this.idGaleria = idGaleria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
}
