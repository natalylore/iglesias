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
    private Iglesia iglesia;
    private Precios precio;

    public IglesiaPrecio() {
    }

    public IglesiaPrecio(Iglesia iglesia, Precios precio) {
        this.iglesia = iglesia;
        this.precio = precio;
    }

    public Iglesia getIglesia() {
        return iglesia;
    }

    public void setIglesia(Iglesia iglesia) {
        this.iglesia = iglesia;
    }

    public Precios getPrecio() {
        return precio;
    }

    public void setPrecio(Precios precio) {
        this.precio = precio;
    }
    
}
