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
import turismo.religioso.catalogos.CatalogoServicios;
import turismo.religioso.clases.Servicios;

/**
 *
 * @author Checho
 */
@ManagedBean
@ViewScoped
public class ControladorServicio {

    /**
     * Creates a new instance of ControladorServicio
     */
    private  Servicios objServicios;//objeto nuevo
    private Servicios objServicioSeleccionado;
    private ArrayList<Servicios> ListaServicios;
    public ControladorServicio() {
        objServicios = new Servicios();
        CargarServicios();
    }
   
    private void CargarServicios(){
        try {
            ListaServicios = CatalogoServicios.ListadoServicios();
        } catch (Exception ex) {
            Logger.getLogger(ControladorServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//   public void Limpiar(){
//       FacesContext contexto=FacesContext.getCurrentInstance();
//        RequestContext.getCurrentInstance().reset("dlgNuevoCliente:frmNuevoCliente:pngCliente");  
//        
//    }
    
      
     public void insertarServicio() {
        try {
            int dato = CatalogoServicios.ExisteServicio(objServicios.getIdServicio());
            
            if (dato<1) {
                
                
                CatalogoServicios.InsertarServicios(objServicios);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "INSERTADO", "El registro fue Insertado");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarServicios();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCliente.hide()");
                objServicios = new Servicios();
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

        public void eliminarServicio(){
        try {
            
//            if (CatalogoSector.EliminarSector(objSector)) {
            //int dato = CatalogoContactos.ExisteContacto(objPrecioSeleccionado.getIdContacto());
            
            //if (dato<1) {
                
                CatalogoServicios.EliminarServicios(objServicioSeleccionado.getIdServicio());
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Alerta!!", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarServicios();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCliente.hide()");
                objServicioSeleccionado = new Servicios();
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

    public Servicios getObjServicios() {
        return objServicios;
    }

    public void setObjServicios(Servicios objServicios) {
        this.objServicios = objServicios;
    }

    public Servicios getObjServicioSeleccionado() {
        return objServicioSeleccionado;
    }

    public void setObjServicioSeleccionado(Servicios objServicioSeleccionado) {
        this.objServicioSeleccionado = objServicioSeleccionado;
    }

    public ArrayList<Servicios> getListaServicios() {
        return ListaServicios;
    }

    public void setListaServicios(ArrayList<Servicios> ListaServicios) {
        this.ListaServicios = ListaServicios;
    }

   }
