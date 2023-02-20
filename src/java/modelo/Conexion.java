
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String user ="SOLIDARIAUSER";
    String pass= "123";
    
    public Connection conectar(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con=DriverManager.getConnection(url,user,pass);
        }catch (Exception e){
            
        }
        return con;
    }
    

}