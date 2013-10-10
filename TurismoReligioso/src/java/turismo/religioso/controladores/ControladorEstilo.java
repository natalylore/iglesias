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
import turismo.religioso.catalogos.CatalogoEstilo;
import turismo.religioso.catalogos.CatalogoPunto;
import turismo.religioso.clases.Estilo;
import turismo.religioso.clases.Punto;


/**
 *
 * @author Fmla Jimenez
 */
@ManagedBean
@ViewScoped
public class ControladorEstilo {

    /**
     * Creates a new instance of ControladorEstilo
     */
    private  Estilo objEstilo;//objeto nuevo
    private Estilo objEstiloSeleccionado;
    private ArrayList<Estilo> ListaEstilo;
    public ControladorEstilo() {
        objEstilo = new Estilo();
        CargarEstilo();
    }
    private void CargarEstilo(){
        try {
            ListaEstilo = CatalogoEstilo.ListadoEstilo();
        } catch (Exception ex) {
            Logger.getLogger(ControladorPunto.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
      
     public void insertarEstilo() {
        try {
            int dato = CatalogoEstilo.ExisteEstilo(objEstilo.getIdEstilo());
            
            if (dato<1) {
                
                
                CatalogoEstilo.InsertarEstilo(objEstilo);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "INSERTADO", "El registro fue Insertado");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarEstilo();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCliente.hide()");
                objEstilo = new Estilo();
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

        public void eliminarEstilo(){
        try {
            
//            if (CatalogoSector.EliminarSector(objSector)) {
//            int dato = CatalogoEstilo.ExisteEstilo(objPuntoSeleccionado.getIdEstilo());
//            
//            if (dato<1) {
                
               
                CatalogoEstilo.EliminarEstilo(objEstiloSeleccionado.getIdEstilo());
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Alerta!!", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarEstilo();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCliente.hide()");
                objEstiloSeleccionado = new Estilo();
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

    public Estilo getObjEstilo() {
        return objEstilo;
    }

    public void setObjEstilo(Estilo objEstilo) {
        this.objEstilo = objEstilo;
    }

    public Estilo getObjEstiloSeleccionado() {
        return objEstiloSeleccionado;
    }

    public void setObjEstiloSeleccionado(Estilo objEstiloSeleccionado) {
        this.objEstiloSeleccionado = objEstiloSeleccionado;
    }

    public ArrayList<Estilo> getListaEstilo() {
        return ListaEstilo;
    }

    public void setListaEstilo(ArrayList<Estilo> ListaEstilo) {
        this.ListaEstilo = ListaEstilo;
    }

   
        
        
}
