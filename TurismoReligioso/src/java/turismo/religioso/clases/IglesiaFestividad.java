/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.clases;

/**
 *
 * @author Checho
 */
public class IglesiaFestividad {
    private int iglesia;
    private int festividad;
   
    public IglesiaFestividad() {
    }

    public IglesiaFestividad(int iglesia, int festividad) {
        this.iglesia = iglesia;
        this.festividad = festividad;
    }

    public int getIglesia() {
        return iglesia;
    }

    public void setIglesia(int iglesia) {
        this.iglesia = iglesia;
    }

    public int getFestividad() {
        return festividad;
    }

    public void setFestividad(int festividad) {
        this.festividad = festividad;
    }
    
}
