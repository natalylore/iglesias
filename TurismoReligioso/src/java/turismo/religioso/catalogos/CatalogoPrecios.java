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
import turismo.religioso.clases.Precios;
import turismo.religioso.conexion.Conexion;

import static turismo.religioso.conexion.Conexion.estado;

/**
 *
 * @author Checho
 */
public class CatalogoPrecios extends Conexion{
    public static boolean  InsertarPrecios(Precios miPrecio) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call InsertarPrecios(?,?)}") ;
    
               ObjProcedimiento.setString(1,miPrecio.getDescripcion());
               ObjProcedimiento.setFloat(2,miPrecio.getPrecio());
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: InsertarPrecio "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static Precios  ObtenerPrecio(int IdPrecio) throws Exception{


         Precios miPrecio=null;
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ObtenerPrecios(?)}") ;
               ObjProcedimiento.setInt(1,IdPrecio);

               ResultSet respuesta = ObjProcedimiento.executeQuery();
               miPrecio = new Precios();
               while(respuesta.next())  {
                            miPrecio.setIdPrecio(respuesta.getInt(1));
                            miPrecio.setDescripcion(respuesta.getString(2));
                            miPrecio.setPrecio(respuesta.getFloat(3));
                                    }

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ObtenerPrecio "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return miPrecio;
    }

    public static int ExistePrecio(int IdPrecio) throws Exception{
        int resultado=0;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ExistePrecios(?,?)}") ;
               ObjProcedimiento.setInt(1,IdPrecio);
               ObjProcedimiento.registerOutParameter(2, Types.INTEGER);
               ObjProcedimiento.execute();
               resultado=ObjProcedimiento.getInt(2);

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ExistePrecios "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

   
    public static boolean  EliminarPrecios(int IdPrecios) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call EliminarPrecio(?)}") ;
               ObjProcedimiento.setInt(1,IdPrecios);
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo:  EliminarPrecios "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static ArrayList<Precios>  ListadoPrecios() throws Exception{

        ArrayList<Precios> lista = new ArrayList<Precios>();
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ListarPrecios()}") ;
               ResultSet respuesta = ObjProcedimiento.executeQuery();
               if (respuesta.next()){
                    do {
                        Precios miPrecio = new Precios(respuesta.getInt(1),respuesta.getString(2),respuesta.getFloat(3));
                        lista.add(miPrecio);

                    } while(respuesta.next());

              }


         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ListadoPrecios "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return lista;
    }

}
