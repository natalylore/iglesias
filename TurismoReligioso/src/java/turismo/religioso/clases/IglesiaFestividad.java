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
    private Iglesia iglesia;
    private Festividades festividad;
    
    public IglesiaFestividad(Iglesia iglesia, Festividades festividad) {
        this.iglesia = iglesia;
        this.festividad = festividad;
    }
    public IglesiaFestividad() {
    }

    public Iglesia getIglesia() {
        return iglesia;
    }

    public void setIglesia(Iglesia iglesia) {
        this.iglesia = iglesia;
    }

    public Festividades getFestividad() {
        return festividad;
    }

    public void setFestividad(Festividades festividad) {
        this.festividad = festividad;
    }
    
}
