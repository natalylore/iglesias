/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.controladores;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.DefaultRequestContext;
import turismo.religioso.catalogos.CatalogoServicios;
import turismo.religioso.clases.Servicios;


/**
 *
 * @author Fmla Jimenez
 */
@ManagedBean
@RequestScoped
public class ControladorServicios {

    /**
     * Creates a new instance of ControladorServicios
     */
    private  Servicios objServicio;//objeto nuevo
    private Servicios objServicioSeleccionado;
    private ArrayList<Servicios> ListaServicio;
    public ControladorServicios() {
        objServicio = new Servicios();
        CargarPunto();
    }
       
    private void CargarPunto(){
        try {
            ListaServicio = CatalogoServicios.ListadoServicios();
        } catch (Exception ex) {
            Logger.getLogger(ControladorPunto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void insertarServicio() {
        try {
            int dato = CatalogoServicios.ExisteServicio(objServicio.getIdServicio());
            
            if (dato<1) {
                
                
                CatalogoServicios.InsertarServicios(objServicio);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "INSERTADO", "El registro fue Insertado");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarPunto();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCliente.hide()");
                objServicio = new Servicios();
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Alerta!!", "El registro ya fue Insertado Anteriormente");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta!!", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
//
        public void eliminarServicios(){
        try {
            
//            if (CatalogoSector.EliminarSector(objSector)) {
//            int dato = CatalogoServicios.ExisteServicio(objPuntoSeleccionado.getIdServicio());
//            
//            if (dato<1) {
                
               
                CatalogoServicios.EliminarServicios(objServicioSeleccionado.getIdServicio());
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Alerta!!", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarPunto();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCliente.hide()");
                objServicioSeleccionado = new Servicios();
//            } else {
//                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                        "Alerta!!", "No se puede Eliminar el servicio tiene Registros Asignados");
//                FacesContext.getCurrentInstance().addMessage(null, message);
//            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta!!", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }        
    }
        
        
}
