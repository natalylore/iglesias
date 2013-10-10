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
import turismo.religioso.clases.Galeria;

import turismo.religioso.conexion.Conexion;
import static turismo.religioso.conexion.Conexion.estado;

/**
 *
 * @author Fmla Jimenez
 */
public class CatalogoGaleria extends Conexion{
    
    public static boolean  InsertarGaleria(Galeria miPunto) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call InsertarGaleria(?,?,?)}") ;
               ObjProcedimiento.setString(1,miPunto.getDescripcion());
               //ObjProcedimiento.setBlob(2,miPunto.getImagen());
               
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: InsertarPunto "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    /*public static Punto  ObtenerPunto(int IdPunto) throws Exception{


         Punto miPunto=null;
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ObtenerPunto(?)}") ;
               ObjProcedimiento.setInt(1,IdPunto);

               ResultSet respuesta = ObjProcedimiento.executeQuery();
               miPunto = new Punto();
               while(respuesta.next())  {
                            miPunto.setIdPunto(respuesta.getInt(1));
                            miPunto.setLatitud(respuesta.getFloat(2));
                            miPunto.setLongitud(respuesta.getFloat(3));
                                    }

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ObtenerPunto "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return miPunto;
    }

    public static int ExistePunto(int IdPunto) throws Exception{
        int resultado=0;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ExistePunto(?,?)}") ;
               ObjProcedimiento.setInt(1,IdPunto);
               ObjProcedimiento.registerOutParameter(2, Types.INTEGER);
               ObjProcedimiento.execute();
               resultado=ObjProcedimiento.getInt(2);

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ExistePunto "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

   
    public static boolean  EliminarPunto(int IdPunto) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call EliminarPunto(?)}") ;
               ObjProcedimiento.setInt(1,IdPunto);
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo:  EliminarPunto "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static ArrayList<Punto>  ListadoPunto() throws Exception{

        ArrayList<Punto> lista = new ArrayList<Punto>();
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ListarPunto()}") ;
               ResultSet respuesta = ObjProcedimiento.executeQuery();
               if (respuesta.next()){
                    do {
                        Punto miPunto = new Punto(respuesta.getInt(1),respuesta.getFloat(2),respuesta.getFloat(3));
                        lista.add(miPunto);

                    } while(respuesta.next());

              }


         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ListadoPunto "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return lista;
    }*/

}