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
import turismo.religioso.catalogos.CatalogoFestividades;
import turismo.religioso.clases.Festividades;

/**
 *
 * @author Checho
 */
@ManagedBean
@ViewScoped
public class ControladorFestividades {

    /**
     * Creates a new instance of ControladorFestividades
     */
    private  Festividades objFestividades;//objeto nuevo
    private Festividades objFestividadSeleccionado;
    private ArrayList<Festividades> ListaFestividad;
    public ControladorFestividades() {
        objFestividades = new Festividades();
        CargarFestividad();
    }
        
    private void CargarFestividad(){
        try {
            ListaFestividad = CatalogoFestividades.ListadoFestividades();
        } catch (Exception ex) {
            Logger.getLogger(ControladorFestividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//   public void Limpiar(){
//       FacesContext contexto=FacesContext.getCurrentInstance();
//        RequestContext.getCurrentInstance().reset("dlgNuevoCliente:frmNuevoCliente:pngCliente");  
//        
//    }
    
      
     public void insertarPrecios() {
        try {
            int dato = CatalogoFestividades.ExisteFestividad(objFestividades.getIdFestividades());
            
            if (dato<1) {
                
                
                CatalogoFestividades.InsertarFestividad(objFestividades);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "INSERTADO", "El registro fue Insertado");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarFestividad();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCliente.hide()");
                objFestividades = new Festividades();
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

        public void eliminarFestividad(){
        try {
            
//            if (CatalogoSector.EliminarSector(objSector)) {
            //int dato = CatalogoContactos.ExisteContacto(objPrecioSeleccionado.getIdContacto());
            
            //if (dato<1) {
                
                CatalogoFestividades.EliminarFestividad(objFestividadSeleccionado.getIdFestividades());
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Alerta!!", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarFestividad();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCliente.hide()");
                objFestividadSeleccionado = new Festividades();
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

    public Festividades getObjFestividades() {
        return objFestividades;
    }

    public void setObjFestividades(Festividades objFestividades) {
        this.objFestividades = objFestividades;
    }

    public Festividades getObjFestividadSeleccionado() {
        return objFestividadSeleccionado;
    }

    public void setObjFestividadSeleccionado(Festividades objFestividadSeleccionado) {
        this.objFestividadSeleccionado = objFestividadSeleccionado;
    }

    public ArrayList<Festividades> getListaFestividad() {
        return ListaFestividad;
    }

    public void setListaFestividad(ArrayList<Festividades> ListaFestividad) {
        this.ListaFestividad = ListaFestividad;
    }
        
}
