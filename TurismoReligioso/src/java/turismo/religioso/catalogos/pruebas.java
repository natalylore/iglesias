/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.catalogos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import turismo.religioso.clases.Estilo;

/**
 *
 * @author Checho
 */
public class pruebas {
    public static void main(String args[])
 
    {
        try {
            ArrayList<Estilo> lista=CatalogoEstilo.ListadoEstilo();
            for (Estilo estilo : lista) {
                System.out.println(estilo.getNombreEstilo());
            }
        } catch (Exception ex) {
            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 
    }
}
