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
import turismo.religioso.catalogos.CatalogoIglesia;
import turismo.religioso.catalogos.CatalogoPunto;
import turismo.religioso.clases.Iglesia;
import turismo.religioso.clases.Punto;


/**
 *
 * @author Checho
 */
@ManagedBean
@ViewScoped
public class ControladorIglesias {

    /**
     * Creates a new instance of ControladorIglesias
     */
    private  Iglesia objIglesias;//objeto nuevo
    private Iglesia objIglesiaSeleccionado;
    private ArrayList<Iglesia> ListaIglesia;
    public ControladorIglesias() {
        objIglesias = new Iglesia();
        CargarIglesia();
    }

    private void CargarIglesia(){
        try {
            ListaIglesia = CatalogoIglesia.ListadoIglesia();
        } catch (Exception ex) {
            Logger.getLogger(ControladorIglesias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//   public void Limpiar(){
//       FacesContext contexto=FacesContext.getCurrentInstance();
//        RequestContext.getCurrentInstance().reset("dlgNuevoCliente:frmNuevoCliente:pngCliente");  
//        
//    }
    
      
     public void insertarIglesia() {
         int dato=0;
        try {
             dato = CatalogoIglesia.ExisteIglesia(objIglesias.getIdIglesia());
            
            if (dato<1) {
                
                
                CatalogoIglesia.InsertarIglesia(objIglesias);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "INSERTADO", "El registro fue Insertado");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarIglesia();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCliente.hide()");
                objIglesias = new Iglesia();
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Alerta!!", "El registro ya fue Insertado Anteriormente");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta!!"+ dato, e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

        public void eliminarIglesia(){
        try {
            
//            if (CatalogoSector.EliminarSector(objSector)) {
            //int dato = CatalogoContactos.ExisteContacto(objPrecioSeleccionado.getIdContacto());
            
            //if (dato<1) {
                
                CatalogoIglesia.EliminarIglesia(objIglesiaSeleccionado.getIdIglesia());
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Alerta!!", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarIglesia();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCliente.hide()");
                objIglesiaSeleccionado = new Iglesia();
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
public String ObtenerPunto(int id){
       String cadena="";
        try {
            
            Punto obj = CatalogoPunto.ObtenerPunto(id);
            cadena= "LAT: "+obj.getLatitud()+"  LON: "+ obj.getLongitud();
            
        } catch (Exception ex) {
            Logger.getLogger(ControladorIglesias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadena;
    } 
    public Iglesia getObjIglesias() {
        return objIglesias;
    }

    public void setObjIglesias(Iglesia objIglesias) {
        this.objIglesias = objIglesias;
    }

    public Iglesia getObjIglesiaSeleccionado() {
        return objIglesiaSeleccionado;
    }

    public void setObjIglesiaSeleccionado(Iglesia objIglesiaSeleccionado) {
        this.objIglesiaSeleccionado = objIglesiaSeleccionado;
    }

    public ArrayList<Iglesia> getListaIglesia() {
        return ListaIglesia;
    }

    public void setListaIglesia(ArrayList<Iglesia> ListaIglesia) {
        this.ListaIglesia = ListaIglesia;
    }

}
