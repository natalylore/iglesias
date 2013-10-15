/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.clases;

/**
 *
 * @author Fmla Jimenez
 */
public class IglesiaServicios {
    private int iglesia;
    private int servicio;

    public IglesiaServicios() {
    }

    public IglesiaServicios(int iglesia, int servicio) {
        this.iglesia = iglesia;
        this.servicio = servicio;
    }

    public int getIglesia() {
        return iglesia;
    }

    public void setIglesia(int iglesia) {
        this.iglesia = iglesia;
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }

 
}
