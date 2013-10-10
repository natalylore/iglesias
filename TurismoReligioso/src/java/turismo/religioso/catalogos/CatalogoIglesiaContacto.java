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
    public static  IglesiaContactos ObtenerIglesiaContactos(IglesiaContactos IdIglesiaContacto) throws Exception{


         IglesiaContactos miIglesiaContacto=null;
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ObtenerIglesiaContactos(?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesiaContacto.getIglesia().getIdIglesia());
               ObjProcedimiento.setInt(2,IdIglesiaContacto.getContacto().getIdContacto());

               ResultSet respuesta = ObjProcedimiento.executeQuery();
               miIglesiaContacto = new IglesiaContactos();
               while(respuesta.next())  {
                            miIglesiaContacto.setIglesia(CatalogoIglesia.ObtenerIglesia(respuesta.getInt(1)));
                            miIglesiaContacto.setContacto(CatalogoContactos.ObtenerContacto(respuesta.getInt(2)));
                         
                                    }

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ObtenerIglesiaContacto "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return miIglesiaContacto;
    }

    public static int ExisteIglesiaContacto(IglesiaContactos IdIglesiaContacto) throws Exception{
        int resultado=0;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ExisteContactos(?,?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesiaContacto.getIglesia().getIdIglesia());
               ObjProcedimiento.setInt(2,IdIglesiaContacto.getContacto().getIdContacto());
               ObjProcedimiento.registerOutParameter(3, Types.INTEGER);
               ObjProcedimiento.execute();
               resultado=ObjProcedimiento.getInt(3);

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ExisteIglesiaContacto "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

   
    public static boolean  EliminarIglesiaContacto(IglesiaContactos IdIglesiaContacto) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call EliminarIglesiaContactos(?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesiaContacto.getIglesia().getIdIglesia());
               ObjProcedimiento.setInt(2,IdIglesiaContacto.getContacto().getIdContacto());
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo:  EliminarIglesiaContactos "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static ArrayList<IglesiaContactos>  ListadoIglesiaContactos() throws Exception{

        ArrayList<IglesiaContactos> lista = new ArrayList<IglesiaContactos>();
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ListarIglesiaContacto()}") ;
               ResultSet respuesta = ObjProcedimiento.executeQuery();
               if (respuesta.next()){
                    do {
                        IglesiaContactos miIglesiaContacto = new IglesiaContactos(CatalogoIglesia.ObtenerIglesia(respuesta.getInt(1)),CatalogoContactos.ObtenerContacto(respuesta.getInt(2)));
                        lista.add(miIglesiaContacto);

                    } while(respuesta.next());

              }


         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ListadoIglesiaContacto "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return lista;
    }


}
