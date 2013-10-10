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
import turismo.religioso.catalogos.CatalogoContactos;
import turismo.religioso.clases.Contactos;

/**
 *
 * @author Checho
 */
@ManagedBean
@ViewScoped
public class ControladorContactos {

    /**
     * Creates a new instance of ControladorContactos
     */
    private  Contactos objContacto;//objeto nuevo
    private Contactos objContactoSeleccionado;
    private ArrayList<Contactos> ListaContacto;
    public ControladorContactos() {
        objContacto = new Contactos();
        CargarContacto();
    }
    
      private void CargarContacto(){
        try {
            ListaContacto = CatalogoContactos.ListadoContactos();
        } catch (Exception ex) {
            Logger.getLogger(ControladorContactos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//   public void Limpiar(){
//       FacesContext contexto=FacesContext.getCurrentInstance();
//        RequestContext.getCurrentInstance().reset("dlgNuevoCliente:frmNuevoCliente:pngCliente");  
//        
//    }
    
      
     public void insertarContacto() {
        try {
            int dato = CatalogoContactos.ExisteContacto(objContacto.getIdContacto());
            
            if (dato<1) {
                
                
                CatalogoContactos.InsertarContacto(objContacto);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "INSERTADO", "El registro fue Insertado");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarContacto();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCliente.hide()");
                objContacto = new Contactos();
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

        public void eliminarContacto(){
        try {
            
//            if (CatalogoSector.EliminarSector(objSector)) {
           // int dato = CatalogoContactos.ExisteContacto(objContactoSeleccionado.getIdContacto());
            
           // if (dato<1) {
                
                CatalogoContactos.EliminarContacto(objContactoSeleccionado.getIdContacto());
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Alerta!!", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarContacto();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCliente.hide()");
                objContactoSeleccionado = new Contactos();
            /*} else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Alerta!!", "No se puede Eliminar al Contacto tiene Registros Asignados");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }*/
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta!!", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }        
    }

    public Contactos getObjContacto() {
        return objContacto;
    }

    public void setObjContacto(Contactos objContacto) {
        this.objContacto = objContacto;
    }

    public Contactos getObjContactoSeleccionado() {
        return objContactoSeleccionado;
    }

    public void setObjContactoSeleccionado(Contactos objContactoSeleccionado) {
        this.objContactoSeleccionado = objContactoSeleccionado;
    }

    public ArrayList<Contactos> getListaContacto() {
        return ListaContacto;
    }

    public void setListaContacto(ArrayList<Contactos> ListaContacto) {
        this.ListaContacto = ListaContacto;
    }
        
}
