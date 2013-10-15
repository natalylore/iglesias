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
import javax.swing.JOptionPane;
import org.primefaces.context.DefaultRequestContext;
import turismo.religioso.catalogos.CatalogoIglesia;
import turismo.religioso.catalogos.CatalogoIglesiaPrecio;
import turismo.religioso.catalogos.CatalogoPrecios;
import turismo.religioso.clases.Iglesia;
import turismo.religioso.clases.IglesiaPrecio;
import turismo.religioso.clases.Precios;

/**
 *
 * @author Checho
 */
@ManagedBean
@ViewScoped
public class ControladorIglesiaPrecio {

    /**
     * Creates a new instance of ControladorIglesiaPrecio
     */
    public ControladorIglesiaPrecio() {
                CargarIglesiaPrecio();
objIglesiaPrecios = new IglesiaPrecio();
    }
    private  IglesiaPrecio objIglesiaPrecios;//objeto nuevo
    private IglesiaPrecio objIglesiaPreciosSeleccionado;
    private ArrayList<IglesiaPrecio> ListaIglesiaPrecios;

    private void CargarIglesiaPrecio(){
        try {
            ListaIglesiaPrecios = CatalogoIglesiaPrecio.ListadoIglesiaPrecio();
        } catch (Exception ex) {
            Logger.getLogger(ControladorIglesiaPrecio.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
      
     public void insertarIglesiaPrecios() {
        
           // int dato = CatalogoIglesiaPrecio.ExisteIglesiaPrecios(objIglesiaPrecios);
            
           // if (dato<1) {
         System.err.println("Inicio del metodo");      
         // JOptionPane.showMessageDialog(ControladorIglesiaPrecio.this, "llega");
               try { 
                CatalogoIglesiaPrecio.InsertarIglesiaPrecio(objIglesiaPrecios);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "INSERTADO", "El registro fue Insertado");
                FacesContext.getCurrentInstance().addMessage(null, message);
                CargarIglesiaPrecio();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCliente.hide()");
                objIglesiaPrecios = new IglesiaPrecio();
//            } else {
//                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                        "Alerta!!", "El registro ya fue Insertado Anteriormente");
//                FacesContext.getCurrentInstance().addMessage(null, message);
//            }
        } catch (Exception e) {
            System.out.println("ERROR "+e.getMessage());
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
public String ObtenerNombre(int id){
       String cadena="";
        try {
            
            Iglesia obj = CatalogoIglesia.ObtenerIglesia(id);
            cadena= obj.getNombre();
            
        } catch (Exception ex) {
            System.out.println("ERROR "+ex.getMessage());
            Logger.getLogger(ControladorIglesiaPrecio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadena;
    } 
public String ObtenerPrecio(int id){
       String cadena="";
        try {
            
            Precios obj = CatalogoPrecios.ObtenerPrecio(id);
            cadena=obj.getDescripcion()+ " VALOR:"+obj.getPrecio();
            
        } catch (Exception ex) {
            System.out.println("ERROR "+ex.getMessage());
            Logger.getLogger(ControladorIglesiaPrecio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadena;
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
