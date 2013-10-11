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
import turismo.religioso.catalogos.CatalogoIglesiaServicios;
import turismo.religioso.clases.IglesiaServicios;


/**
 *
 * @author Fmla Jimenez
 */
@ManagedBean
@ViewScoped
public class ControladorIglesiaServicios {

    /**
     * Creates a new instance of ControladorIglesiaServicios
     */
    private  IglesiaServicios objIglesiaServicios;//objeto nuevo
    private IglesiaServicios objIglesiaServiciosSeleccionado;
    private ArrayList<IglesiaServicios> ListaServicios;
    
    public ControladorIglesiaServicios() {
        objIglesiaServicios = new IglesiaServicios();
        CargarIglesiaServicios();
    }
    private void CargarIglesiaServicios(){
        try {
            ListaServicios = CatalogoIglesiaServicios.ListadoIglesiaServicios();
        } catch (Exception ex) {
            Logger.getLogger(ControladorIglesiaServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
      
     public void insertarIglesiaServicio() {
        try {
            int dato = CatalogoIglesiaServicios.ExisteIglesiaServicio(objIglesiaServicios);
            
            if (dato<1) {
                
                
                CatalogoIglesiaServicios.InsertarIglesiaServicio(objIglesiaServicios);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "INSERTADO", "El registro fue Insertado");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarIglesiaServicios();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCliente.hide()");
                objIglesiaServicios = new IglesiaServicios();
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

        public void eliminarIglesiaServicios(){
        try {
            
//            if (CatalogoSector.EliminarSector(objSector)) {
//            int dato = CatalogoEstilo.ExisteEstilo(objPuntoSeleccionado.getIdEstilo());
//            
//            if (dato<1) {
                
               
                CatalogoIglesiaServicios.EliminarIglesiaServicio(objIglesiaServiciosSeleccionado);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Alerta!!", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarIglesiaServicios();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCliente.hide()");
                objIglesiaServiciosSeleccionado = new IglesiaServicios();
//            } else {
//                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                        "Alerta!!", "No se puede Eliminar al Docente tiene Registros Asignados");
//                FacesContext.getCurrentInstance().addMessage(null, message);
//            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta!!", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }        
    }

    public IglesiaServicios getObjIglesiaServicios() {
        return objIglesiaServicios;
    }

    public void setObjIglesiaServicios(IglesiaServicios objIglesiaServicios) {
        this.objIglesiaServicios = objIglesiaServicios;
    }

    public IglesiaServicios getObjIglesiaServiciosSeleccionado() {
        return objIglesiaServiciosSeleccionado;
    }

    public void setObjIglesiaServiciosSeleccionado(IglesiaServicios objIglesiaServiciosSeleccionado) {
        this.objIglesiaServiciosSeleccionado = objIglesiaServiciosSeleccionado;
    }

    public ArrayList<IglesiaServicios> getListaServicios() {
        return ListaServicios;
    }

    public void setListaServicios(ArrayList<IglesiaServicios> ListaServicios) {
        this.ListaServicios = ListaServicios;
    }
        
        
}
