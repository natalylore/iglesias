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
import turismo.religioso.catalogos.CatalogoGaleria;
import turismo.religioso.clases.Galeria;


/**
 *
 * @author Checho
 */
@ManagedBean
@ViewScoped
public class ControladorGaleria {

    /**
     * Creates a new instance of ControladorGaleria
     */
    private  Galeria objGaleria;//objeto nuevo
    private Galeria objGaleriaSeleccionado;
    private ArrayList<Galeria> ListaGaleria;
    public ControladorGaleria() {
         objGaleria = new Galeria();
        CargarGaleria();
    }
        
    private void CargarGaleria(){
        try {
            ListaGaleria = CatalogoGaleria.ListadoGaleria();
        } catch (Exception ex) {
            Logger.getLogger(ControladorGaleria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//   public void Limpiar(){
//       FacesContext contexto=FacesContext.getCurrentInstance();
//        RequestContext.getCurrentInstance().reset("dlgNuevoCliente:frmNuevoCliente:pngCliente");  
//        
//    }
    
      
     public void insertarGaleria() {
        try {
            int dato = CatalogoGaleria.ExisteGaleria(objGaleria.getIdGaleria());
            
            if (dato<1) {
                
                
                CatalogoGaleria.InsertarGaleria(objGaleria);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "INSERTADO", "El registro fue Insertado");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarGaleria();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCliente.hide()");
                objGaleria = new Galeria();
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

        public void eliminarGaleria(){
        try {
            
//            if (CatalogoSector.EliminarSector(objSector)) {
            //int dato = CatalogoContactos.ExisteContacto(objPrecioSeleccionado.getIdContacto());
            
            //if (dato<1) {
                
                CatalogoGaleria.EliminarGaleria(objGaleriaSeleccionado.getIdGaleria());
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Alerta!!", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarGaleria();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCliente.hide()");
                objGaleriaSeleccionado = new Galeria();
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

    public Galeria getObjGaleria() {
        return objGaleria;
    }

    public void setObjGaleria(Galeria objGaleria) {
        this.objGaleria = objGaleria;
    }

    public Galeria getObjGaleriaSeleccionado() {
        return objGaleriaSeleccionado;
    }

    public void setObjGaleriaSeleccionado(Galeria objGaleriaSeleccionado) {
        this.objGaleriaSeleccionado = objGaleriaSeleccionado;
    }

    public ArrayList<Galeria> getListaGaleria() {
        return ListaGaleria;
    }

    public void setListaGaleria(ArrayList<Galeria> ListaGaleria) {
        this.ListaGaleria = ListaGaleria;
    }
        
}
