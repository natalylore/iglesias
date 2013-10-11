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
import turismo.religioso.catalogos.CatalogoIglesiaContacto;
import turismo.religioso.clases.IglesiaContactos;


/**
 *
 * @author Fmla Jimenez
 */
@ManagedBean
@ViewScoped
public class ControladorIglesiaContactos {

    /**
     * Creates a new instance of ControladorIglesiaContactos
     */
    private IglesiaContactos objIglesiaContactos;//objeto nuevo
    private IglesiaContactos objIglesiaContactosSeleccionado;
    private ArrayList<IglesiaContactos> ListaContactosSeleccionado;
    public ControladorIglesiaContactos() {
         objIglesiaContactos = new IglesiaContactos();
        CargarIglesiaContactos();
    }
        
    private void CargarIglesiaContactos(){
        try {
            ListaContactosSeleccionado = CatalogoIglesiaContacto.ListadoIglesiaContactos();
        } catch (Exception ex) {
            Logger.getLogger(ControladorGaleria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//   public void Limpiar(){
//       FacesContext contexto=FacesContext.getCurrentInstance();
//        RequestContext.getCurrentInstance().reset("dlgNuevoCliente:frmNuevoCliente:pngCliente");  
//        
//    }
    
      
     public void insertarIglesiaContactos() {
        try {
            int dato = CatalogoIglesiaContacto.ExisteIglesiaContacto(objIglesiaContactos);
            
            if (dato<1) {
                
                
                CatalogoIglesiaContacto.InsertarIglesiaContacto(objIglesiaContactos);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "INSERTADO", "El registro fue Insertado");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarIglesiaContactos();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCliente.hide()");
                objIglesiaContactos = new IglesiaContactos();
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
                
                CatalogoIglesiaContacto.EliminarIglesiaContacto(objIglesiaContactosSeleccionado);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Alerta!!", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarIglesiaContactos();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCliente.hide()");
                objIglesiaContactosSeleccionado = new IglesiaContactos();
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

    public IglesiaContactos getObjIglesiaContactos() {
        return objIglesiaContactos;
    }

    public void setObjIglesiaContactos(IglesiaContactos objIglesiaContactos) {
        this.objIglesiaContactos = objIglesiaContactos;
    }

    public IglesiaContactos getObjIglesiaContactosSeleccionado() {
        return objIglesiaContactosSeleccionado;
    }

    public void setObjIglesiaContactosSeleccionado(IglesiaContactos objIglesiaContactosSeleccionado) {
        this.objIglesiaContactosSeleccionado = objIglesiaContactosSeleccionado;
    }

    public ArrayList<IglesiaContactos> getListaContactosSeleccionado() {
        return ListaContactosSeleccionado;
    }

    public void setListaContactosSeleccionado(ArrayList<IglesiaContactos> ListaContactosSeleccionado) {
        this.ListaContactosSeleccionado = ListaContactosSeleccionado;
    }
        
    
}
