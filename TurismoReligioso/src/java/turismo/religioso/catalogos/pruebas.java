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

/**
 *
 * @author Checho
 */
public class pruebas {
    public static void main(String args[])
 
    {
        try {
            ArrayList<Galeria> lista=CatalogoGaleria.ListadoGaleria();
            for (Galeria galeria : lista) {
                System.out.println(galeria.getDescripcion());
            }
        } catch (Exception ex) {
            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 
    }
}
