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
import turismo.religioso.clases.IglesiaFestividad;
import turismo.religioso.conexion.Conexion;

import static turismo.religioso.conexion.Conexion.estado;

/**
 *
 * @author Checho
 */
public class CatalogoIglesiaFestividad extends Conexion{
    public static boolean  InsertarIglesiaFestividad(IglesiaFestividad miIglesiaFestividad) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call InsertarIglesiaFestividad(?,?)}") ;
    
               ObjProcedimiento.setInt(1,miIglesiaFestividad.getIglesia().getIdIglesia());
               ObjProcedimiento.setInt(2,miIglesiaFestividad.getFestividad().getIdFestividades());
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: InsertarIglesiaFestividad "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }
    public static  IglesiaFestividad ObtenerIglesiaFestividad(IglesiaFestividad IdIglesiaFestividad) throws Exception{


         IglesiaFestividad miIglesiaFestividad=null;
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ObtenerIglesiaFestividad(?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesiaFestividad.getIglesia().getIdIglesia());
               ObjProcedimiento.setInt(2,IdIglesiaFestividad.getFestividad().getIdFestividades());

               ResultSet respuesta = ObjProcedimiento.executeQuery();
               miIglesiaFestividad = new IglesiaFestividad();
               while(respuesta.next())  {
                            miIglesiaFestividad.setIglesia(CatalogoIglesia.ObtenerIglesia(respuesta.getInt(1)));
                            miIglesiaFestividad.setFestividad(CatalogoFestividades.ObtenerFestividades(respuesta.getInt(2)));
                         
                                    }

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ObtenerIglesiaFestividad "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return miIglesiaFestividad;
    }

    public static int ExisteIglesiaFestividad (IglesiaFestividad IdIglesiaFestividad) throws Exception{
        int resultado=0;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ExisteIglesiaFestividad(?,?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesiaFestividad.getIglesia().getIdIglesia());
               ObjProcedimiento.setInt(2,IdIglesiaFestividad.getFestividad().getIdFestividades());
               ObjProcedimiento.registerOutParameter(3, Types.INTEGER);
               ObjProcedimiento.execute();
               resultado=ObjProcedimiento.getInt(3);

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ExisteIglesiaFestividad "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

   
    public static boolean  EliminarIglesiaFestividad(IglesiaFestividad IdIglesiaFestividad) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call EliminarIglesiaFestivade(?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesiaFestividad.getIglesia().getIdIglesia());
               ObjProcedimiento.setInt(2,IdIglesiaFestividad.getFestividad().getIdFestividades());
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo:  EliminarIglesiaFestividad"+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static ArrayList<IglesiaFestividad>  ListadoIglesiaFestividads() throws Exception{

        ArrayList<IglesiaFestividad> lista = new ArrayList<IglesiaFestividad>();
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ListarIglesiaFestividad()}") ;
               ResultSet respuesta = ObjProcedimiento.executeQuery();
               if (respuesta.next()){
                    do {
                        IglesiaFestividad miIglesiaFestividad = new IglesiaFestividad(CatalogoIglesia.ObtenerIglesia(respuesta.getInt(1)),CatalogoFestividades.ObtenerFestividades(respuesta.getInt(2)));
                        lista.add(miIglesiaFestividad);

                    } while(respuesta.next());

              }


         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ListadoIglesiaFestividad "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return lista;
    }
    
}
