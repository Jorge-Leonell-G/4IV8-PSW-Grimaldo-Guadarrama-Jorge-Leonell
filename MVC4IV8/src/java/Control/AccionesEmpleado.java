/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

//import de nuestro modelo de la clase Empleado para su posterior instancia
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author rash2
 */
public class AccionesEmpleado {
    
    /*
    Son todas las operaciones o requerimientos funcionales con que el usuario operara el sistema
    
    registrarEmpleado -> Empleado e
    actualizarEmpleado -> Empleado e
    eliminarEmpleado -> int id
    buscarEmpleadoporID -> int id
    buscarTodoslosEmpleados -> arrayList 
    verificarUsuario -> String userName, password
    */
    
    public static int registrarEmpleado(Empleado e){
        int status = 0;
        try{//aqui instanciamos a la clase encargada de traer lo definido para la conexion
            Connection con = Conexion.getConnection();
            String q = "insert into empleados (nom_emp, pass_emp, email_emp, pais_emp)"
                    + "values(?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //uso getters % setters
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getPais());
            
            status = ps.executeUpdate();
            System.out.println("Registro Exitoso del Empleado");
            con.close();
            
        }catch(Exception ex){
            System.out.println("Error al registrar al Empleado");
            System.out.println(ex.getMessage());
        }
        //retornamos status puesto que es la query
        return status;
    }
    
}
