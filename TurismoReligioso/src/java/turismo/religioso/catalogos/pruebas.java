/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.catalogos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import turismo.religioso.clases.Festividades;
import turismo.religioso.clases.Galeria;
import turismo.religioso.clases.IglesiaContactos;
import turismo.religioso.clases.IglesiaFestividad;
import turismo.religioso.clases.IglesiaPrecio;
import turismo.religioso.controladores.ControladorIglesiaFestividad;
import turismo.religioso.controladores.ControladorIglesiaGaleria;


/**
 *
 * @author Checho
 */
public class pruebas {
    public static void main(String args[]) 
 
    {
        String cadena="";
        try {
            Galeria obj = CatalogoGaleria.ObtenerGaleria(1);
            cadena=obj.getDescripcion();
           
        } catch (Exception ex) {
            System.out.println("ERROR "+ex.getMessage());
            Logger.getLogger(ControladorIglesiaGaleria.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(cadena);
    }
}
