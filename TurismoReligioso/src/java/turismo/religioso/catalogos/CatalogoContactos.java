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
import turismo.religioso.clases.Contactos;
import turismo.religioso.conexion.Conexion;
import static turismo.religioso.conexion.Conexion.estado;

/**
 *
 * @author Checho
 */
public class CatalogoContactos extends Conexion{
        
    public static boolean  InsertarContacto(Contactos miContacto) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call InsertarContactos(?,?,?)}") ;
        
               ObjProcedimiento.setString(1,miContacto.getNombre());
               ObjProcedimiento.setString(2,miContacto.getTelefono());
               ObjProcedimiento.setString(3,miContacto.getCorreo());
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: InsertarContacto "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static Contactos  ObtenerContacto(int IdContacto) throws Exception{


         Contactos miContacto=null;
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ObtenerContacto(?)}") ;
               ObjProcedimiento.setInt(1,IdContacto);

               ResultSet respuesta = ObjProcedimiento.executeQuery();
               miContacto = new Contactos();
               while(respuesta.next())  {
                            miContacto.setIdContacto(respuesta.getInt(1));
                            miContacto.setNombre(respuesta.getString(2));
                            miContacto.setTelefono(respuesta.getString(3));
                            miContacto.setCorreo(respuesta.getString(4));
                                    }

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ObtenerContacto "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return miContacto;
    }

    public static int ExisteContacto(int IdContacto) throws Exception{
        int resultado=0;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ExisteContacto(?,?)}") ;
               ObjProcedimiento.setInt(1,IdContacto);
               ObjProcedimiento.registerOutParameter(2, Types.INTEGER);
               ObjProcedimiento.execute();
               resultado=ObjProcedimiento.getInt(2);

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ExisteContacto "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

   
    public static boolean  EliminarContacto(int IdContactos) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call EliminarContactos(?)}") ;
               ObjProcedimiento.setInt(1,IdContactos);
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo:  EliminarContactos "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static ArrayList<Contactos>  ListadoContactos() throws Exception{

        ArrayList<Contactos> lista = new ArrayList<Contactos>();
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ListarContactos()}") ;
               ResultSet respuesta = ObjProcedimiento.executeQuery();
               if (respuesta.next()){
                    do {
                        Contactos miContacto = new Contactos(respuesta.getInt(1),respuesta.getString(2),respuesta.getString(3),respuesta.getString(4));
                        lista.add(miContacto);

                    } while(respuesta.next());

              }


         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ListarContactos "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return lista;
    }
}
