/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author leone
 */

import Control.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class ProductoDAO {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Producto listarId(int id){
        Producto p = new Producto();
        try{
            
            Connection con = Conexion.getConexion();
            String q = "SELECT * FROM MProducto WHERE id_pro ="+id;
                
            PreparedStatement ps = con.prepareStatement(q);
           
            ps.setInt(1, p.getId_producto());
            ps.setString(2, p.getNombre_producto());
            ps.setBinaryStream(3, p.getImagen_producto());
            ps.setString(4, p.getDescripcion_producto());
            ps.setInt(4, p.getStock_producto());
            ps.setDouble(5, p.getPrecio_producto());
       
           
        }catch(Exception e){
            System.out.println("Error al listar los datos");
        }
        return p;
    }
    
    public List listar(){
        List<Producto> productos = new ArrayList();
        String q = "SELECT * FROM MProducto";
        try{
            con = cn.getConexion();
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setId_producto(rs.getInt(1));
                p.setNombre_producto(rs.getString(2));
                p.setImagen_producto(rs.getBinaryStream(3));
                p.setDescripcion_producto(rs.getString(4));
                p.setPrecio_producto(rs.getDouble(5));
                p.setStock_producto(rs.getInt(6));
                
                productos.add(p);
            }
        }catch(Exception e){
            System.out.println("Error al listar los productos");
            System.out.println(e.getMessage());
        }
        return productos;
    }
    
    public void listarIMG(int id, HttpServletResponse response){
        String q = "SELECT * FROM MProducto WHERE id_pro ="+id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        //procederemos a implementar metodos para la visualizacion de nuestras imagenes
        try{
            outputStream = response.getOutputStream();
            con = cn.getConexion();
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            if(rs.next()){
                inputStream = rs.getBinaryStream("imagen_pro");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            
            int i = 0;
            while((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }
        }catch(Exception e){
            System.out.println("Error al listar las imagenes");
            System.out.println(e.getMessage());
        }
    }
    
}
