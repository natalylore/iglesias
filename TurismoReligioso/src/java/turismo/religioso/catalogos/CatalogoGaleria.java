/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.catalogos;

import java.awt.Graphics;
import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
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

               ObjProcedimiento=conector.prepareCall("{call InsertarGaleria(?,?)}") ;
               ObjProcedimiento.setString(1,miPunto.getDescripcion());
               ObjProcedimiento.setBlob(2,convertirImagenABlob(miPunto.getImagen()));
               
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: InsertarGaleria "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static Galeria  ObtenerGaleria(int Idgaleria) throws Exception{


         Galeria miPunto=null;
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ObtenerGaleria(?)}") ;
               ObjProcedimiento.setInt(1,Idgaleria);

               ResultSet respuesta = ObjProcedimiento.executeQuery();
               miPunto = new Galeria();
               while(respuesta.next())  {
                            miPunto.setIdGaleria(respuesta.getInt(1));
                            miPunto.setDescripcion(respuesta.getString(2));
                            miPunto.setImagen(obtenerImagen(respuesta.getBlob(3)));
                                    }

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ObtenerGaleria "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return miPunto;
    }

    public static int ExisteGaleria(int IdGaleria) throws Exception{
        int resultado=0;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ExisteGaleria(?,?)}") ;
               ObjProcedimiento.setInt(1,IdGaleria);
               ObjProcedimiento.registerOutParameter(2, Types.INTEGER);
               ObjProcedimiento.execute();
               resultado=ObjProcedimiento.getInt(2);

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ExisteGaleria "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

   
    public static boolean  EliminarGaleria(int IdGaleria) throws Exception{
        boolean resultado=false;

         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call EliminarGaleria(?)}") ;
               ObjProcedimiento.setInt(1,IdGaleria);
               ObjProcedimiento.execute();
               resultado=true;

         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo:  EliminarGaleria "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return resultado;
    }

    public static ArrayList<Galeria>  ListadoGaleria() throws Exception{

        ArrayList<Galeria> lista = new ArrayList<Galeria>();
         CallableStatement ObjProcedimiento;
         Connection conector = estado();

         try{

               ObjProcedimiento=conector.prepareCall("{call ListarGaleria()}") ;
               ResultSet respuesta = ObjProcedimiento.executeQuery();
               if (respuesta.next()){
                    do {
                        Galeria miPunto = new Galeria(respuesta.getInt(1),respuesta.getString(2),obtenerImagen(respuesta.getBlob(3)));
                        lista.add(miPunto);

                    } while(respuesta.next());

              }


         }catch(Exception pp)
         {
             JOptionPane.showMessageDialog(null,"Error en Catalogo: ListadoGaleria "+pp.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
         }finally{
             conector.close();
         }

        return lista;
    }

    private static Image obtenerImagen(Blob blob) throws IOException, SQLException {
        Image imagen=null;
        imagen= javax.imageio.ImageIO.read(blob.getBinaryStream());
        return imagen;
    }

    public static Blob convertirImagenABlob ( Image imagen ) {

      Blob imagenBlob = null;
      BufferedImage bi = new BufferedImage ( imagen.getWidth ( null ), imagen.getHeight ( null ), BufferedImage.TYPE_INT_ARGB );
      Graphics bg = bi.getGraphics ();
      bg.drawImage ( imagen, 0, 0, null );
      bg.dispose ();

      ByteArrayOutputStream baos = new ByteArrayOutputStream ();
      try {
         ImageIO.write (bi,"foto", baos );
         baos.flush ();
         baos.close ();
      } catch ( IOException e ) {
         e.printStackTrace ();
      }

      byte [] imagenByte = baos.toByteArray ();

      try {
         imagenBlob = new SerialBlob ( imagenByte );
      } catch ( SerialException se ) {
         se.printStackTrace ();
      } catch ( SQLException sqle ) {
         sqle.printStackTrace ();
      }
      return imagenBlob;
   }
}