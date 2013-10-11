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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.DefaultRequestContext;
import turismo.religioso.catalogos.CatalogoIglesiaFestividad;
import turismo.religioso.clases.IglesiaFestividad;


/**
 *
 * @author Checho
 */
@ManagedBean
@ViewScoped
public class ControladorIglesiaFestividad {

    /**
     * Creates a new instance of ControladorIglesiaFestividad
     */
    private IglesiaFestividad objIglesiaFestividad;//objeto nuevo
    private IglesiaFestividad objIglesiaFestividadSeleccionado;
    private ArrayList<IglesiaFestividad> ListaFestividadSeleccionado;
    public ControladorIglesiaFestividad() {
        objIglesiaFestividad = new IglesiaFestividad();
        CargarIglesiaFestividad();
    }

    private void CargarIglesiaFestividad(){
        try {
            ListaFestividadSeleccionado = CatalogoIglesiaFestividad.ListadoIglesiaFestividads();
        } catch (Exception ex) {
            Logger.getLogger(ControladorIglesiaFestividad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//   public void Limpiar(){
//       FacesContext contexto=FacesContext.getCurrentInstance();
//        RequestContext.getCurrentInstance().reset("dlgNuevoCliente:frmNuevoCliente:pngCliente");  
//        
//    }
    
      
     public void insertarIglesiaFestividad() {
        try {
            int dato = CatalogoIglesiaFestividad.ExisteIglesiaFestividad(objIglesiaFestividad);
            
            if (dato<1) {
                
                
                CatalogoIglesiaFestividad.InsertarIglesiaFestividad(objIglesiaFestividad);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "INSERTADO", "El registro fue Insertado");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarIglesiaFestividad();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCliente.hide()");
                objIglesiaFestividad = new IglesiaFestividad();
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

        public void eliminarIglesiaContatos(){
        try {
            
//            if (CatalogoSector.EliminarSector(objSector)) {
            //int dato = CatalogoContactos.ExisteContacto(objPrecioSeleccionado.getIdContacto());
            
            //if (dato<1) {
                
                CatalogoIglesiaFestividad.EliminarIglesiaFestividad(objIglesiaFestividadSeleccionado);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Alerta!!", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarIglesiaFestividad();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCliente.hide()");
                objIglesiaFestividadSeleccionado = new IglesiaFestividad();
            /*} else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Alerta!!", "No se puede Eliminar al Docente tiene Registros Asignados");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }*/
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta!!", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }        
    }
}
