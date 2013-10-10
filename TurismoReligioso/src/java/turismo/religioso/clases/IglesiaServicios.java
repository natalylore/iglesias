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
    private Iglesia iglesia;
    private Servicios servicio;

    public IglesiaServicios() {
    }

    public IglesiaServicios(Iglesia iglesia, Servicios servicio) {
        this.iglesia = iglesia;
        this.servicio = servicio;
    }

    public Iglesia getIglesia() {
        return iglesia;
    }

    public void setIglesia(Iglesia iglesia) {
        this.iglesia = iglesia;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }
    
}
