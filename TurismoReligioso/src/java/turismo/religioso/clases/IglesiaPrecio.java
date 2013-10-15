/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.clases;

/**
 *
 * @author Checho
 */
public class IglesiaPrecio {
    private int iglesia;
    private int precio;

    public IglesiaPrecio() {
    }

    public IglesiaPrecio(int iglesia, int precio) {
        this.iglesia = iglesia;
        this.precio = precio;
    }

    public int getIglesia() {
        return iglesia;
    }

    public void setIglesia(int iglesia) {
        this.iglesia = iglesia;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
}
