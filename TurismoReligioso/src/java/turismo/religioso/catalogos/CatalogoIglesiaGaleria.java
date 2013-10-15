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
import turismo.religioso.clases.IglesiaGaleria;
import turismo.religioso.conexion.Conexion;

import static turismo.religioso.conexion.Conexion.estado;

/**
 *
 * @author Checho
 */
public class CatalogoIglesiaGaleria extends Conexion{
     public static boolean  InsertarIglesiaGaleria(IglesiaGaleria miIglesiaGaleria) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call InsertarIglesiaGaleria(?,?)}") ;
    
               ObjProcedimiento.setInt(1,miIglesiaGaleria.getIglesia());
               ObjProcedimiento.setInt(2,miIglesiaGaleria.getGaleria());
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: InsertarIglesiaGaleria "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }
    public static  IglesiaGaleria ObtenerIglesiaGaleria(IglesiaGaleria IdIglesiaGaleria) throws Exception{


         IglesiaGaleria miIglesiaGaleria=null;
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ObtenerIglesiaGaleria(?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesiaGaleria.getIglesia());
               ObjProcedimiento.setInt(2,IdIglesiaGaleria.getGaleria());

               ResultSet respuesta = ObjProcedimiento.executeQuery();
               miIglesiaGaleria = new IglesiaGaleria();
               while(respuesta.next())  {
                            miIglesiaGaleria.setIglesia(respuesta.getInt(1));
                            miIglesiaGaleria.setGaleria(respuesta.getInt(2));
                         
                                    }

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ObtenerIglesiaGaleria "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return miIglesiaGaleria;
    }

    public static int ExisteIglesiaGaleria(IglesiaGaleria IdIglesiaGaleria) throws Exception{
        int resultado=0;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ExisteIglesiaGaleria(?,?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesiaGaleria.getIglesia());
               ObjProcedimiento.setInt(2,IdIglesiaGaleria.getGaleria());
               ObjProcedimiento.registerOutParameter(3, Types.INTEGER);
               ObjProcedimiento.execute();
               resultado=ObjProcedimiento.getInt(3);

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ExisteIglesiaGaleria "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

   
    public static boolean  EliminarIglesiaGaleria(IglesiaGaleria IdIglesiaGaleria) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call EliminarIglesiaGaleria(?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesiaGaleria.getIglesia());
               ObjProcedimiento.setInt(2,IdIglesiaGaleria.getGaleria());
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo:  EliminarIglesiaGaleria "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static ArrayList<IglesiaGaleria>  ListadoIglesiaGaleria() throws Exception{

        ArrayList<IglesiaGaleria> lista = new ArrayList<IglesiaGaleria>();
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ListarIglesiaGaleria()}") ;
               ResultSet respuesta = ObjProcedimiento.executeQuery();
               if (respuesta.next()){
                    do {
                        IglesiaGaleria miIglesiaGaleria = new IglesiaGaleria(respuesta.getInt(1),respuesta.getInt(2));
                        lista.add(miIglesiaGaleria);

                    } while(respuesta.next());

              }


         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ListadoIglesiaGaleria "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return lista;
    }
    
}
