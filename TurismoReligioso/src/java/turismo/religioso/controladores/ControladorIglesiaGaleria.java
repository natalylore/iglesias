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
import turismo.religioso.catalogos.CatalogoIglesiaGaleria;
import turismo.religioso.clases.Galeria;
import turismo.religioso.clases.IglesiaGaleria;


/**
 *
 * @author Fmla Jimenez
 */
@ManagedBean
@ViewScoped
public class ControladorIglesiaGaleria {

    /**
     * Creates a new instance of ControladorIglesiaGaleria
     */
   private  IglesiaGaleria objIglesiaGaleria;//objeto nuevo
    private IglesiaGaleria objIglesiaGaleriaSeleccionado;
    private ArrayList<IglesiaGaleria> ListaIglesiaGaleria;
    
    public ControladorIglesiaGaleria() {
        objIglesiaGaleria = new IglesiaGaleria();
        CargarIglesiaGaleria();
    }
    private void CargarIglesiaGaleria(){
        try {
            ListaIglesiaGaleria = CatalogoIglesiaGaleria.ListadoIglesiaGaleria();
        } catch (Exception ex) {
            Logger.getLogger(ControladorIglesiaGaleria.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
      
     public void insertarIglesiaGaleria() {
        try {
            int dato = CatalogoIglesiaGaleria.ExisteIglesiaGaleria(objIglesiaGaleria);
            
            if (dato<1) {
                
                
                CatalogoIglesiaGaleria.InsertarIglesiaGaleria(objIglesiaGaleria);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "INSERTADO", "El registro fue Insertado");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarIglesiaGaleria();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCliente.hide()");
                objIglesiaGaleria = new IglesiaGaleria();
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
public String ObtenerNombreGaleria(int id){
       String cadena="";
        try {
            Galeria obj = CatalogoGaleria.ObtenerGaleria(id);
            cadena=obj.getDescripcion();
           
        } catch (Exception ex) {
            System.out.println("ERROR "+ex.getMessage());
            Logger.getLogger(ControladorIglesiaGaleria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadena;
    }
        public void eliminarIglesiGaleria(){
        try {
            
//            if (CatalogoSector.EliminarSector(objSector)) {
//            int dato = CatalogoEstilo.ExisteEstilo(objPuntoSeleccionado.getIdEstilo());
//            
//            if (dato<1) {
                
               
                CatalogoIglesiaGaleria.EliminarIglesiaGaleria(objIglesiaGaleriaSeleccionado);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Alerta!!", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarIglesiaGaleria();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCliente.hide()");
                objIglesiaGaleriaSeleccionado = new IglesiaGaleria();
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

    public IglesiaGaleria getObjIglesiaGaleria() {
        return objIglesiaGaleria;
    }

    public void setObjIglesiaGaleria(IglesiaGaleria objIglesiaGaleria) {
        this.objIglesiaGaleria = objIglesiaGaleria;
    }

    public IglesiaGaleria getObjIglesiaGaleriaSeleccionado() {
        return objIglesiaGaleriaSeleccionado;
    }

    public void setObjIglesiaGaleriaSeleccionado(IglesiaGaleria objIglesiaGaleriaSeleccionado) {
        this.objIglesiaGaleriaSeleccionado = objIglesiaGaleriaSeleccionado;
    }

    public ArrayList<IglesiaGaleria> getListaIglesiaGaleria() {
        return ListaIglesiaGaleria;
    }

    public void setListaIglesiaGaleria(ArrayList<IglesiaGaleria> ListaIglesiaGaleria) {
        this.ListaIglesiaGaleria = ListaIglesiaGaleria;
    }
      
}
