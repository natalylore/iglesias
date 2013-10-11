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
import turismo.religioso.clases.Iglesia;
import turismo.religioso.conexion.Conexion;

import static turismo.religioso.conexion.Conexion.estado;

/**
 *
 * @author Checho
 */
public class CatalogoIglesia extends Conexion{
    public static boolean  InsertarIglesia(Iglesia miIglesia) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call InsertarIglesia(?,?,?,?,?,?,?,?,?)}") ;
               ObjProcedimiento.setString(1,miIglesia.getNombre());
               ObjProcedimiento.setString(2,miIglesia.getDireccion());
               ObjProcedimiento.setString(3,miIglesia.getDescripcion());
               ObjProcedimiento.setString(4,miIglesia.getHistoria());
               ObjProcedimiento.setString(5,miIglesia.getHorarioVisitas());
               ObjProcedimiento.setString(6,miIglesia.getHorarioMisas());
               ObjProcedimiento.setString(7,miIglesia.getLeyendas());
               ObjProcedimiento.setInt(8,miIglesia.getPunto().getIdPunto());
               ObjProcedimiento.setInt(9,miIglesia.getEstilo().getIdEstilo());
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: InsertarIglesia "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static Iglesia ObtenerIglesia(int IdIglesia) throws Exception{


         Iglesia miIglesia=null;
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ObtenerIglesia(?)}") ;
               ObjProcedimiento.setInt(1,IdIglesia);

               ResultSet respuesta = ObjProcedimiento.executeQuery();
               miIglesia = new Iglesia();
               while(respuesta.next())  {
                            miIglesia.setIdIglesia(respuesta.getInt(1));
                            miIglesia.setNombre(respuesta.getString(2));
                            miIglesia.setDireccion(respuesta.getString(3));
                            miIglesia.setDescripcion(respuesta.getString(4));
                            miIglesia.setHistoria(respuesta.getString(5));
                            miIglesia.setHorarioVisitas(respuesta.getString(6));
                            miIglesia.setHorarioMisas(respuesta.getString(7));
                            miIglesia.setLeyendas(respuesta.getString(8));
                            miIglesia.setPunto(CatalogoPunto.ObtenerPunto(respuesta.getInt(9)));
                            miIglesia.setEstilo(CatalogoEstilo.ObtenerEstilo(respuesta.getInt(10)));
                            
                            
                                    }

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ObtenerIlgesia "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return miIglesia;
    }

    public static int ExisteIglesia(int IdIglesia) throws Exception{
        int resultado=0;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ExisteIglesia(?,?)}") ;
               ObjProcedimiento.setInt(1,IdIglesia);
               ObjProcedimiento.registerOutParameter(2, Types.INTEGER);
               ObjProcedimiento.execute();
               resultado=ObjProcedimiento.getInt(2);

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ExisteIglesia "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

   
    public static boolean  EliminarIglesia(int IdIglesia) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call EliminarIglesia(?)}") ;
               ObjProcedimiento.setInt(1,IdIglesia);
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo:  EliminarIglesia "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static ArrayList<Iglesia>  ListadoIglesia() throws Exception{

        ArrayList<Iglesia> lista = new ArrayList<Iglesia>();
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ListarIglesia()}") ;
               ResultSet respuesta = ObjProcedimiento.executeQuery();
               if (respuesta.next()){
                    do {
                        Iglesia miIglesia = new Iglesia(respuesta.getInt(1),respuesta.getString(2),respuesta.getString(3),respuesta.getString(4),respuesta.getString(5),respuesta.getString(6),respuesta.getString(7),respuesta.getString(8),CatalogoPunto.ObtenerPunto(respuesta.getInt(9)), CatalogoEstilo.ObtenerEstilo(respuesta.getInt(10)));
                        lista.add(miIglesia);

                    } while(respuesta.next());

              }


         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ListadoIglesias "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return lista;
    }

}
