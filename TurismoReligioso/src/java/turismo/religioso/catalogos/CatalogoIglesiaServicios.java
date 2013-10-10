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
import turismo.religioso.clases.IglesiaServicios;
import turismo.religioso.conexion.Conexion;

import static turismo.religioso.conexion.Conexion.estado;

/**
 *
 * @author Checho
 */
public class CatalogoIglesiaServicios extends Conexion{
 public static boolean  InsertarIglesiaServicio(IglesiaServicios miIglesiaServicio) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call InsertarIglesiaServicios(?,?)}") ;
    
               ObjProcedimiento.setInt(1,miIglesiaServicio.getIglesia().getIdIglesia());
               ObjProcedimiento.setInt(2,miIglesiaServicio.getServicio().getIdServicio());
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: InsertarIglesiaServicio "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }
    public static  IglesiaServicios ObtenerIglesiaServicio(IglesiaServicios IdIglesiaServicio) throws Exception{


         IglesiaServicios miIglesiaServicio=null;
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ObtenerIglesiaServicios(?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesiaServicio.getIglesia().getIdIglesia());
               ObjProcedimiento.setInt(2,IdIglesiaServicio.getServicio().getIdServicio());

               ResultSet respuesta = ObjProcedimiento.executeQuery();
               miIglesiaServicio = new IglesiaServicios();
               while(respuesta.next())  {
                            miIglesiaServicio.setIglesia(CatalogoIglesia.ObtenerIglesia(respuesta.getInt(1)));
                            miIglesiaServicio.setServicio(CatalogoServicios.ObtenerServicios(respuesta.getInt(2)));
                         
                                    }

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ObtenerIglesiaServicios "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return miIglesiaServicio;
    }

    public static int ExisteIglesiaServicio(IglesiaServicios IdIglesiaServicio) throws Exception{
        int resultado=0;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ExisteIglesiaServicio(?,?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesiaServicio.getIglesia().getIdIglesia());
               ObjProcedimiento.setInt(2,IdIglesiaServicio.getServicio().getIdServicio());
               ObjProcedimiento.registerOutParameter(3, Types.INTEGER);
               ObjProcedimiento.execute();
               resultado=ObjProcedimiento.getInt(3);

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ExisteIglesiaServicio "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

   
    public static boolean  EliminarIglesiaServicio(IglesiaServicios IdIglesiaServicio) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call EliminarIglesiaServicios(?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesiaServicio.getIglesia().getIdIglesia());
               ObjProcedimiento.setInt(2,IdIglesiaServicio.getServicio().getIdServicio());
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo:  EliminarIglesiaServicios "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static ArrayList<IglesiaServicios>  ListadoIglesiaServicios() throws Exception{

        ArrayList<IglesiaServicios> lista = new ArrayList<IglesiaServicios>();
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ListarIglesiaServicios()}") ;
               ResultSet respuesta = ObjProcedimiento.executeQuery();
               if (respuesta.next()){
                    do {
                        IglesiaServicios miIglesiaServicio = new IglesiaServicios(CatalogoIglesia.ObtenerIglesia(respuesta.getInt(1)),CatalogoServicios.ObtenerServicios(respuesta.getInt(2)));
                        lista.add(miIglesiaServicio);

                    } while(respuesta.next());

              }


         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ListadoIglesiaServicios "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return lista;
    }    
}
