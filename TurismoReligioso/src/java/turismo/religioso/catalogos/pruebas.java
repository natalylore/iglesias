/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.catalogos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import turismo.religioso.clases.Festividades;
import turismo.religioso.clases.IglesiaContactos;
import turismo.religioso.clases.IglesiaFestividad;
import turismo.religioso.clases.IglesiaPrecio;
import turismo.religioso.controladores.ControladorIglesiaFestividad;


/**
 *
 * @author Checho
 */
public class pruebas {
    public static void main(String args[]) 
 
    {
       String cadena="";
        try {
            Festividades obj = CatalogoFestividades.ObtenerFestividades(1);
            cadena=obj.getNombreFestividad();
            
        } catch (Exception ex) {
            System.out.println("ERROR "+ex.getMessage());
            Logger.getLogger(ControladorIglesiaFestividad.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(cadena);
    }
}
