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
import turismo.religioso.catalogos.CatalogoPunto;
import turismo.religioso.clases.Punto;

/**
 *
 * @author Checho
 */
@ManagedBean
@ViewScoped
public class ControladorPunto {

    /**
     * Creates a new instance of ControladorPunto
     */
    private  Punto objPunto;//objeto nuevo
    private Punto objPuntoSeleccionado;
    private ArrayList<Punto> ListaPunto;
    public ControladorPunto() {
        objPunto = new Punto();
        CargarPunto();
    }
       
    private void CargarPunto(){
        try {
            ListaPunto = CatalogoPunto.ListadoPunto();
        } catch (Exception ex) {
            Logger.getLogger(ControladorPunto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//   public void Limpiar(){
//       FacesContext contexto=FacesContext.getCurrentInstance();
//        RequestContext.getCurrentInstance().reset("dlgNuevoCliente:frmNuevoCliente:pngCliente");  
//        
//    }
    
      
     public void insertarPunto() {
        try {
            int dato = CatalogoPunto.ExistePunto(objPunto.getIdPunto());
            
            if (dato<1) {
                
                
                CatalogoPunto.InsertarPunto(objPunto);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "INSERTADO", "El registro fue Insertado");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarPunto();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCliente.hide()");
                objPunto = new Punto();
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

        public void eliminarPunto(){
        try {
            
//            if (CatalogoSector.EliminarSector(objSector)) {
            int dato = CatalogoPunto.ExistePunto(objPuntoSeleccionado.getIdPunto());
            
            if (dato<1) {
                
               
                CatalogoPunto.EliminarPunto(objPuntoSeleccionado.getIdPunto());
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Alerta!!", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarPunto();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCliente.hide()");
                objPuntoSeleccionado = new Punto();
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Alerta!!", "No se puede Eliminar al Docente tiene Registros Asignados");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta!!", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }        
    }
}
