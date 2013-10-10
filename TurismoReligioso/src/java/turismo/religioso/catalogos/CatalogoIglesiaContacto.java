/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.catalogos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import turismo.religioso.clases.IglesiaContactos;
import turismo.religioso.conexion.Conexion;

import static turismo.religioso.conexion.Conexion.estado;

/**
 *
 * @author Checho
 */
public class CatalogoIglesiaContacto extends Conexion{
    public static boolean  InsertarIglesiaContacto(IglesiaContactos miIglesiaContacto) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call InsertarIglesiaContactos(?,?)}") ;
    
               ObjProcedimiento.setInt(1,miIglesiaContacto.getIglesia().getIdIglesia());
               ObjProcedimiento.setInt(2,miIglesiaContacto.getContacto().getIdContacto());
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: InsertarIglesiaContacto "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }


}
