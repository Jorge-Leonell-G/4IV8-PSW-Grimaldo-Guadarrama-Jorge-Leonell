/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.MUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leone
 */
public class AccionesUsuario {
    
    /*
    registrar Empleado -> Empleado e
    actualizarEmpleado-> Empleado e
    eliminarEmpleado -> int id
    buscarEmpleado -> int id
    buscarTodoslosEmpleados -> int id
    
    VerificarUsuario -> este ya quedo listo!!! :D
    */
    
    public static int registrarUsuario(MUsuario u){
        
        int status = 0;
            try{
                Connection con = Conexion.getConexion();
                String q = "INSERT INTO MUsuario (nom_usu, appat_usu, apmat_usu, "
                        + "dir_usu, fechanac_usu, tel_usu, cel_usu, id_formapago, user_usu, "
                        + "pass_usu, privilegio_usu)"
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                PreparedStatement ps = con.prepareStatement(q);
                
                //getters y setters
                ps.setString(1, u.getNombre_usuario());
                ps.setString(2, u.getAppat_usuario());
                ps.setString(3, u.getApmat_usuario());
                ps.setString(4, u.getDir_usuario());
                ps.setString(5, u.getFechanac_usuario());
                ps.setString(6, u.getTel_usuario());
                ps.setString(7, u.getCel_usuario());
                ps.setInt(8, u.getId_formapago());
                ps.setString(9, u.getUser_usuario());
                ps.setString(10, u.getPass_usuario());
                ps.setInt(11, u.getPrivilegio_usuario());
                
                status = ps.executeUpdate();
                System.out.println("¡Registro exitoso del usuario!");
                con.close();
                
            }catch(Exception e){
                System.out.println("Error al registrar al usuario");
                System.out.println(e.getMessage());
            }
            return status;
       
    }
    
    public static int actualizarUsuario(MUsuario u){
        
        int status = 0;
            try{
                Connection con = Conexion.getConexion();
                String q = "UPDATE MUsuario SET nom_usu = ?, appat_usu = ?, apmat_usu = ?, "
                        + "dir_usu = ?, fechanac_usu = ?, tel_usu = ?, cel_usu = ?, formapago_usu = ?, user_usu = ?, "
                        + "pass_usu = ?, privilegio_usu = ?"
                        + "WHERE id_usu = ?";
                
                PreparedStatement ps = con.prepareStatement(q);
                
                //getters y setters
                ps.setString(1, u.getNombre_usuario());
                ps.setString(2, u.getAppat_usuario());
                ps.setString(3, u.getApmat_usuario());
                ps.setString(4, u.getDir_usuario());
                ps.setString(5, u.getFechanac_usuario());
                ps.setString(6, u.getTel_usuario());
                ps.setString(7, u.getCel_usuario());
                ps.setInt(8, u.getId_formapago());
                ps.setString(9, u.getUser_usuario());
                ps.setString(10, u.getPass_usuario());
                ps.setInt(11, u.getPrivilegio_usuario());
                ps.setInt(12, u.getId_usuario());
                
                status = ps.executeUpdate();
                System.out.println("¡Actualización exitosa exitosa del usuario!");
                con.close();
                
            }catch(Exception e){
                System.out.println("Error al actualizar al usuario");
                System.out.println(e.getMessage());
            }
            return status;
       
    }
    
    
    public static int borrarUsuario(int id){
        
        int status = 0;
            try{
                Connection con = Conexion.getConexion();
                String q = "DELETE FROM MUsuario WHERE id_usu = ?";
                
                PreparedStatement ps = con.prepareStatement(q);
                
                //getters y setters
                ps.setInt(1, id);
                
                status = ps.executeUpdate();
                System.out.println("¡Eliminación exitosa exitosa del usuario!");
                con.close();
                
            }catch(Exception e){
                System.out.println("Error al eliminar al usuario");
                System.out.println(e.getMessage());
            }
            return status;
       
    }
    
    
    public static MUsuario buscarUsuarioById(int id){
        //instancia de la clase MUsuario
        MUsuario u = new MUsuario();
            try{
                Connection con = Conexion.getConexion();
                String q = "SELECT * FROM MUsuario WHERE id_emp = ?";
                
                PreparedStatement ps = con.prepareStatement(q);
                
                ps.setInt(1, id);
                
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    u.setId_usuario(rs.getInt(1));
                    u.setNombre_usuario(rs.getString(2));
                    u.setAppat_usuario(rs.getString(3));
                    u.setApmat_usuario(rs.getString(4));
                    u.setDir_usuario(rs.getString(5));
                    u.setFechanac_usuario(rs.getString(6));
                    u.setTel_usuario(rs.getString(7));
                    u.setCel_usuario(rs.getString(8));
                    u.setId_formapago(rs.getInt(9));
                    u.setUser_usuario(rs.getString(10));
                    u.setPass_usuario(rs.getString(11));
                }
                
                System.out.println("¡Usuario encontrado!");
                con.close();
                
            }catch(Exception e){
                System.out.println("Error al buscar al usuario");
                System.out.println(e.getMessage());
            }
            return u;
       
    }
    
    
    public static List<MUsuario> buscarAllUsuarios(){
        //instancia de la clase MUsuario (en forma de un nuevo ArrayList)
        List<MUsuario> lista = new ArrayList<MUsuario>();
            try{
                Connection con = Conexion.getConexion();
                String q = "SELECT * FROM MUsuario WHERE id_emp = ?";
                
                PreparedStatement ps = con.prepareStatement(q);
                
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    MUsuario u = new MUsuario();
                    u.setId_usuario(rs.getInt(1));
                    u.setNombre_usuario(rs.getString(2));
                    u.setAppat_usuario(rs.getString(3));
                    u.setApmat_usuario(rs.getString(4));
                    u.setDir_usuario(rs.getString(5));
                    u.setFechanac_usuario(rs.getString(6));
                    u.setTel_usuario(rs.getString(7));
                    u.setCel_usuario(rs.getString(8));
                    u.setId_formapago(rs.getInt(9));
                    u.setUser_usuario(rs.getString(10));
                    u.setPass_usuario(rs.getString(11));
                    lista.add(u);
                }
                
                System.out.println("¡Usuarios encontrados!");
                con.close();
                
            }catch(Exception e){
                System.out.println("Error al buscar a los usuarios");
                System.out.println(e.getMessage());
            }
            return lista;
       
    }
}
