/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.catalogos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import turismo.religioso.clases.Estilo;
import turismo.religioso.clases.Galeria;
import turismo.religioso.clases.Servicios;

/**
 *
 * @author Checho
 */
public class pruebas {
    public static void main(String args[]) 
 
    {
        try {
            //        try {
            //            ArrayList<Servicios> lista=CatalogoServicios.ListadoServicios();
            //            for (Servicios galeria : lista) {
            //                System.out.println(galeria.getNombre());
            //            }
            //        } catch (Exception ex) {
            //            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
            //        }

                    CatalogoServicios.EliminarServicios(5);
        } catch (Exception ex) {
            System.out.println("error"+ ex.getMessage());
        }
 
    }
}
