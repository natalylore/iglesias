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
import turismo.religioso.catalogos.CatalogoPrecios;
import turismo.religioso.clases.Contactos;
import turismo.religioso.clases.Precios;

/**
 *
 * @author Checho
 */
@ManagedBean
@ViewScoped
public class ControladorPrecios {

    /**
     * Creates a new instance of ControladorPrecios
     */
    private  Precios objPrecios;//objeto nuevo
    private Precios objPrecioSeleccionado;
    private ArrayList<Precios> ListaPrecio;
    public ControladorPrecios() {
        objPrecios = new Precios();
        CargarPrecio();
    }
    
    private void CargarPrecio(){
        try {
            ListaPrecio = CatalogoPrecios.ListadoPrecios();
        } catch (Exception ex) {
            Logger.getLogger(ControladorPrecios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//   public void Limpiar(){
//       FacesContext contexto=FacesContext.getCurrentInstance();
//        RequestContext.getCurrentInstance().reset("dlgNuevoCliente:frmNuevoCliente:pngCliente");  
//        
//    }
    
      
     public void insertarPrecios() {
        try {
            int dato = CatalogoPrecios.ExistePrecio(objPrecios.getIdPrecio());
            
            if (dato<1) {
                
                
                CatalogoPrecios.InsertarPrecios(objPrecios);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "INSERTADO", "El registro fue Insertado");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarPrecio();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCliente.hide()");
                objPrecios = new Precios();
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

        public void eliminarPrecio(){
        try {
            
//            if (CatalogoSector.EliminarSector(objSector)) {
            //int dato = CatalogoContactos.ExisteContacto(objPrecioSeleccionado.getIdContacto());
            
            //if (dato<1) {
                
                CatalogoPrecios.EliminarPrecios(objPrecioSeleccionado.getIdPrecio());
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Alerta!!", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarPrecio();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCliente.hide()");
                objPrecioSeleccionado = new Precios();
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

    public Precios getObjPrecios() {
        return objPrecios;
    }

    public void setObjPrecios(Precios objPrecios) {
        this.objPrecios = objPrecios;
    }

    public Precios getObjPrecioSeleccionado() {
        return objPrecioSeleccionado;
    }

    public void setObjPrecioSeleccionado(Precios objPrecioSeleccionado) {
        this.objPrecioSeleccionado = objPrecioSeleccionado;
    }

    public ArrayList<Precios> getListaPrecio() {
        return ListaPrecio;
    }

    public void setListaPrecio(ArrayList<Precios> ListaPrecio) {
        this.ListaPrecio = ListaPrecio;
    }

}
