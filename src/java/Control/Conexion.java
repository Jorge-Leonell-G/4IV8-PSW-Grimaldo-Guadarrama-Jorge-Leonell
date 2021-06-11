/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author leone
 */

import java.sql.*;

public class Conexion {
    
  public static Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url, username, password;
            
            url = "jdbc:mysql://localhost/Carrito4IV8";
            username = "root";
            password = "Shellframex731--";
            
            return DriverManager.getConnection(url, username, password);
            
        }catch(SQLException sq){
            System.out.println("Error al conectar con la BD");
            System.out.println(sq.getMessage());
            
        }catch(Exception e){
            System.out.println("No se encuentra la clase");
            System.out.println(e.getMessage());
        }
        return null;
    }    
  }