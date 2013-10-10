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
import turismo.religioso.clases.Estilo;

import turismo.religioso.conexion.Conexion;
import static turismo.religioso.conexion.Conexion.estado;

/**
 *
 * @author Fmla Jimenez
 */
public class CatalogoEstilo extends Conexion{
    
    public static boolean  InsertarEstilo(Estilo miEstilo) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call InsertarEstilo(?)}") ;
               ObjProcedimiento.setString(1,miEstilo.getNombreEstilo());             
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: InsertarEstilo "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static Estilo ObtenerEstilo(int idEstilo) throws Exception{


         Estilo miEstilo=null;
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ObtenerEstilo(?)}") ;
               ObjProcedimiento.setInt(1,idEstilo);

               ResultSet respuesta = ObjProcedimiento.executeQuery();
               miEstilo = new Estilo();
               while(respuesta.next())  {
                            miEstilo.setIdEstilo(respuesta.getInt(1));
                            miEstilo.setNombreEstilo(respuesta.getString(2));
                            
                                    }

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ObtenerEstilo "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return miEstilo;
    }

    public static int ExisteEstilo(int IdEstilo) throws Exception{
        int resultado=0;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ExisteEstilo(?,?)}") ;
               ObjProcedimiento.setInt(1,IdEstilo);
               ObjProcedimiento.registerOutParameter(2, Types.INTEGER);
               ObjProcedimiento.execute();
               resultado=ObjProcedimiento.getInt(2);

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ExisteEstilo "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

   
    public static boolean  EliminarEstilo(int IdEstilo) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call EliminarEstilo(?)}") ;
               ObjProcedimiento.setInt(1,IdEstilo);
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo:  EliminarEstilo "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static ArrayList<Estilo>  ListadoEstilo() throws Exception{

        ArrayList<Estilo> lista = new ArrayList<Estilo>();
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ListarEstilo()}") ;
               ResultSet respuesta = ObjProcedimiento.executeQuery();
               if (respuesta.next()){
                    do {
                        Estilo miPunto = new Estilo (respuesta.getInt(1),respuesta.getString(2));
                        lista.add(miPunto);

                    } while(respuesta.next());

              }


         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ListadoEstilo "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return lista;
    }

}
