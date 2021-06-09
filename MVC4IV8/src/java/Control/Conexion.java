/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

/**
 *
 * @author rash2
 */
import java.sql.*;

public class Conexion {
    
    //creacion de una clase para instanciarla en donde la necesitemos (codigo espagueti)
    public static Connection getConnection(){
        String url, userName, password;
        
        url = "jdbc:mysql://localhost/empleados";
        userName = "root";
        password = "Shellframex731--";
        
        //objeto encargado de la conexion
        Connection con = null;
        
        try{                //driver
            Class.forName("com.mysql.jdbc.Driver");
            //establecemos nuestra conexion
            con = DriverManager.getConnection(url, userName, password);
            
            System.out.println("¡Conexión Exitosa con la BD!");
            
        }catch(Exception e){
            System.out.println("Error al conectar con la BD");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        //retornamos al objeto de la conexion
        return con;
    }
    
}
