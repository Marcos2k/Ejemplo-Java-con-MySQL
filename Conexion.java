
package examenfinalpractica;

import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    protected Connection Conector;
    private String Cadena = "jdbc:mysql://localhost/registro";
    private String Usuario = "root";
    private String Clave= "";
    
   protected Connection Conectar(){
        Connection link=null; //valor que vamos a retornar
        try {
            Class.forName("com.mysql.jdbc.Driver"); //registramos el driver
            Conector = DriverManager.getConnection(this.Cadena,Usuario,Clave); //establecemos la conexion
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); //mostramos el error en caso de tenerlo
        }
        return link;
    }
    
    protected void Desconectar(){
        try {
            //preguntamos si el conector no esta cerrado
            if(!this.Conector.isClosed()){
                this.Conector.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); //mostramos el error en caso de tenerlo
        }
    }
}
