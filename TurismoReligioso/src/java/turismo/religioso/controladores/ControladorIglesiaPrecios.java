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
import turismo.religioso.catalogos.CatalogoIglesiaPrecio;
import turismo.religioso.clases.IglesiaPrecio;


/**
 *
 * @author Fmla Jimenez
 */
@ManagedBean
@ViewScoped
public class ControladorIglesiaPrecios {

    /**
     * Creates a new instance of ControladorIglesiaPrecios
     */
   private  IglesiaPrecio objIglesiaPrecios;//objeto nuevo
    private IglesiaPrecio objIglesiaPreciosSeleccionado;
    private ArrayList<IglesiaPrecio> ListaIglesiaPrecios;
    public ControladorIglesiaPrecios() {
        objIglesiaPrecios = new IglesiaPrecio();
        CargarIglesiaPrecio();
    }
    private void CargarIglesiaPrecio(){
        try {
            ListaIglesiaPrecios = CatalogoIglesiaPrecio.ListadoIglesiaPrecio();
        } catch (Exception ex) {
            Logger.getLogger(ControladorIglesiaPrecios.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
      
     public void insertarIglesiaPrecios() {
        try {
            int dato = CatalogoIglesiaPrecio.ExisteIglesiaPrecios(objIglesiaPrecios);
            
            if (dato<1) {
                
                
                CatalogoIglesiaPrecio.InsertarIglesiaPrecio(objIglesiaPrecios);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "INSERTADO", "El registro fue Insertado");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarIglesiaPrecio();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCliente.hide()");
                objIglesiaPrecios = new IglesiaPrecio();
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

        public void eliminarIglesiaPrecio(){
        try {
            
//            if (CatalogoSector.EliminarSector(objSector)) {
//            int dato = CatalogoEstilo.ExisteEstilo(objPuntoSeleccionado.getIdEstilo());
//            
//            if (dato<1) {
                
               
                CatalogoIglesiaPrecio.EliminarIglesiaPrecio(objIglesiaPreciosSeleccionado);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Alerta!!", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarIglesiaPrecio();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCliente.hide()");
                objIglesiaPreciosSeleccionado = new IglesiaPrecio();
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

    public IglesiaPrecio getObjIglesiaPrecios() {
        return objIglesiaPrecios;
    }

    public void setObjIglesiaPrecios(IglesiaPrecio objIglesiaPrecios) {
        this.objIglesiaPrecios = objIglesiaPrecios;
    }

    public IglesiaPrecio getObjIglesiaPreciosSeleccionado() {
        return objIglesiaPreciosSeleccionado;
    }

    public void setObjIglesiaPreciosSeleccionado(IglesiaPrecio objIglesiaPreciosSeleccionado) {
        this.objIglesiaPreciosSeleccionado = objIglesiaPreciosSeleccionado;
    }

    public ArrayList<IglesiaPrecio> getListaIglesiaPrecios() {
        return ListaIglesiaPrecios;
    }

    public void setListaIglesiaPrecios(ArrayList<IglesiaPrecio> ListaIglesiaPrecios) {
        this.ListaIglesiaPrecios = ListaIglesiaPrecios;
    }
        
        
}
