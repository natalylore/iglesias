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
import turismo.religioso.clases.Festividades;
import turismo.religioso.conexion.Conexion;

import static turismo.religioso.conexion.Conexion.estado;

/**
 *
 * @author Checho
 */
public class CatalogoFestividades extends Conexion{
 public static boolean  InsertarFestividad(Festividades miFestividad) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call InsertarFestividades(?,?,?)}") ;
        
               ObjProcedimiento.setString(1,miFestividad.getNombreFestividad());
               ObjProcedimiento.setString(2,miFestividad.getDescripcion());
               java.sql.Date sqlDate = new java.sql.Date(miFestividad.getFecha().getTime());
               ObjProcedimiento.setDate(3,sqlDate);
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: InsertarFestividad "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static Festividades  ObtenerFestividades(int IdFestividad) throws Exception{


         Festividades miFestividad=null;
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ObtenerFestividades(?)}") ;
               ObjProcedimiento.setInt(1,IdFestividad);

               ResultSet respuesta = ObjProcedimiento.executeQuery();
               miFestividad = new Festividades();
               while(respuesta.next())  {
                            miFestividad.setIdFestividades(respuesta.getInt(1));
                            miFestividad.setNombreFestividad(respuesta.getString(2));
                            miFestividad.setFecha(respuesta.getDate(3));
                            
                                    }

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ObtenerFestividades "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return miFestividad;
    }

    public static int ExisteFestividad(int IdFestividad) throws Exception{
        int resultado=0;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ExisteFestividades(?,?)}") ;
               ObjProcedimiento.setInt(1,IdFestividad);
               ObjProcedimiento.registerOutParameter(2, Types.INTEGER);
               ObjProcedimiento.execute();
               resultado=ObjProcedimiento.getInt(2);

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ExisteFestividades "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

   
    public static boolean  EliminarFestividad(int IdFestividad) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call EliminarFestividades(?)}") ;
               ObjProcedimiento.setInt(1,IdFestividad);
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo:  EliminarFestividades "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static ArrayList<Festividades>  ListadoFestividades() throws Exception{

        ArrayList<Festividades> lista = new ArrayList<Festividades>();
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ListarFestividades()}") ;
               ResultSet respuesta = ObjProcedimiento.executeQuery();
               if (respuesta.next()){
                    do {
                        Festividades miFestividad = new Festividades(respuesta.getInt(1),respuesta.getString(2),respuesta.getString(3),respuesta.getDate(4));
                        lista.add(miFestividad);

                    } while(respuesta.next());

              }


         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ListarFestividades "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return lista;
    }   
}
