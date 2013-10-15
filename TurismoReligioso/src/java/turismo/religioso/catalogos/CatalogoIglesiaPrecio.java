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
import turismo.religioso.clases.IglesiaPrecio;

import static turismo.religioso.conexion.Conexion.estado;

/**
 *
 * @author Checho
 */
public class CatalogoIglesiaPrecio {
     public static boolean  InsertarIglesiaPrecio(IglesiaPrecio miIglesiaPrecio) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call InsertarIglesiaPrecio(?,?)}") ;
                ObjProcedimiento.setInt(1,miIglesiaPrecio.getPrecio());
               ObjProcedimiento.setInt(2,miIglesiaPrecio.getIglesia());
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: InsertarIglesiaPrecio "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }
    public static  IglesiaPrecio ObtenerIglesiaPrecio(IglesiaPrecio IdIglesiaPrecio) throws Exception{


         IglesiaPrecio miIglesiaPrecio=null;
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ObtenerIglesiaPrecios(?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesiaPrecio.getPrecio());
               ObjProcedimiento.setInt(2,IdIglesiaPrecio.getIglesia());
               
               ResultSet respuesta = ObjProcedimiento.executeQuery();
               miIglesiaPrecio = new IglesiaPrecio();
               while(respuesta.next())  {
                   miIglesiaPrecio.setPrecio(respuesta.getInt(1));
                            miIglesiaPrecio.setIglesia(respuesta.getInt(2));
                            
                         
                                    }

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ObtenerIglesiaPrecios "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return miIglesiaPrecio;
    }

    public static int ExisteIglesiaPrecios(IglesiaPrecio IdIglesiaPrecio) throws Exception{
        int resultado=0;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ExisteIglesiaPrecio(?,?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesiaPrecio.getPrecio());
               ObjProcedimiento.setInt(2,IdIglesiaPrecio.getIglesia());
               
               ObjProcedimiento.registerOutParameter(3, Types.INTEGER);
               ObjProcedimiento.execute();
               resultado=ObjProcedimiento.getInt(3);

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ExisteIglesiaPrecio "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

   
    public static boolean  EliminarIglesiaPrecio(IglesiaPrecio IdIglesiaPrecio) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call EliminarIglesiaPrecio(?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesiaPrecio.getPrecio());
               ObjProcedimiento.setInt(2,IdIglesiaPrecio.getIglesia());
               
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo:  EliminarIglesiaPrecio "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static ArrayList<IglesiaPrecio>  ListadoIglesiaPrecio() throws Exception{

        ArrayList<IglesiaPrecio> lista = new ArrayList<IglesiaPrecio>();
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ListarIglesiaPrecio()}") ;
               ResultSet respuesta = ObjProcedimiento.executeQuery();
               if (respuesta.next()){
                    do {
                        IglesiaPrecio miIglesiaPrecio = new IglesiaPrecio(respuesta.getInt(2),respuesta.getInt(1));
                        lista.add(miIglesiaPrecio);

                    } while(respuesta.next());

              }


         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ListadoIglesiaPrecio "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return lista;
    }
   
}
