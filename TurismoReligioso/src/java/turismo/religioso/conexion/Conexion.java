/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Checho
 */
public class Conexion {
    
          static String usuario = "root";
          static String password = "123456";
          static String host = "localhost";


          static String puerto = "3306";
          static String base = "baseiglesia";
          static String driver = "com.mysql.jdbc.Driver";


            public  static Connection estado() throws Exception{
		Connection conector = null;
                
        //se leen las propiedades indicando el KEY (identificador) y se imprime

               //Propiedades conf = new Propiedades();
            //  String ip = conf.getPropiedad("direccionIP");
               //host=ip;
               // JOptionPane.showMessageDialog(null,"direccion "+ip);

                String ulrjdbc = "jdbc:mysql://"+host+":"+puerto+"/"+base;

		try {
			 Class.forName(driver).newInstance();
                         conector = DriverManager.getConnection(ulrjdbc,usuario,password);

		}
		catch(SQLException ex)
		{
                         Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null,"No hay conexion con el Servidor  "+ex,"Error Conexion", JOptionPane.WARNING_MESSAGE);
		}
		catch(ClassNotFoundException ex)
		{
                           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                         JOptionPane.showMessageDialog(null,"No hay conexion "+ex,"Error Conexion", JOptionPane.WARNING_MESSAGE);
		}
		return conector;

	}

}
