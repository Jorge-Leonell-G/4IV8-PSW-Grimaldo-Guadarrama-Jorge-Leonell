/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

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

/**
 *
 * @author rash2
 */
public class ProductoDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public MProducto listarId(int id){
        String q = "SELECT * FROM MProducto WHERE id_producto ="+id;
        MProducto p = new MProducto();
        try{
           con = cn.getConexion();
           ps = con.prepareStatement(q);
           rs = ps.executeQuery();
           while(rs.next()){
                p.setId_producto(rs.getInt(1));
                p.setNombre_producto(rs.getString(2));
                p.setDescripcion_producto(rs.getString(3));
                p.setFoto_producto(rs.getBinaryStream(4));
                p.setStock_producto(rs.getInt(5));
                p.setPrecio_producto(rs.getDouble(6));
                
           }
        }catch(Exception e){
            
        }
        return p;
    }
    
    public List listar(){
        List<MProducto> productos = new ArrayList();
        String q = "SELECT * FROM MProducto";
        try{
            con = cn.getConexion();
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                MProducto p = new MProducto();
                p.setId_producto(rs.getInt(1));
                p.setNombre_producto(rs.getString(2));
                p.setDescripcion_producto(rs.getString(3));
                p.setFoto_producto(rs.getBinaryStream(4));
                p.setStock_producto(rs.getInt(5));
                p.setPrecio_producto(rs.getDouble(6));
                productos.add(p);
            }
        }catch(Exception e){
            
        }
        return productos;
    }
    
    public void listarIMG(int id, HttpServletResponse response){
        String q = "SELECT * FROM MProducto WHERE id_producto ="+id;
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
                inputStream = rs.getBinaryStream("foto");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            
            int i = 0;
            while((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }
        }catch(Exception e){
            
        }
    }
}
