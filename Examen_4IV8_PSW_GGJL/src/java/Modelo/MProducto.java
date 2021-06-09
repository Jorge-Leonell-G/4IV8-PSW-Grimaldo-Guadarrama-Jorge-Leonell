/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Control.Conexion;
import java.io.InputStream;

/**
 *
 * @author rash2
 */
import java.sql.*;
import java.util.Vector;

public class MProducto {
    
    /*
    id_producto, id_sabor, id_cantidad, id_tamano, id_presentacion, precio_producto
    Y la nueva adición
    stock_producto
    */
    
    private int id_producto;
    private String nombre_producto, descripcion_producto;
    private InputStream foto_producto;
    private int stock_producto;
    private double precio_producto;
    
    public MProducto(){
        
    }
    
    //se necesita un metodo para visualizar la lista de todos los productos
    
    public Vector<MProducto> listaProductos(){
        Vector<MProducto> lista = new Vector<MProducto>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = Conexion.getConexion();
            String q = "SELECT * FROM MProducto";
            
            ps = con.prepareStatement(q);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                MProducto producto = new MProducto();
                producto.setId_producto(rs.getInt("id_pro"));
                producto.setNombre_producto(rs.getString("nom_pro"));
                producto.setDescripcion_producto(rs.getString("des_pro"));
                producto.setStock_producto(rs.getInt("stock_pro"));
                producto.setPrecio_producto(rs.getDouble("precio_pro"));
                lista.add(producto);

            }
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            lista = null;
        }finally{
            try{
                rs.close();
                ps.close();
                con.close();
                
            }catch(Exception e){
                System.out.println("No se encontró la clase");
                System.out.println(e.getMessage());
            }
        }
        return lista;
    }
    
    //Asi retornamos todos los productos dentro de nuestro vector
    
    //metodo para buscar producto por codigo
    
    public MProducto buscarProducto(int codigoProducto){
        MProducto producto = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = Conexion.getConexion();
            String q = "SELECT * FROM MProducto WHERE id_pro = ?";
            ps = con.prepareStatement(q);
            
            ps.setInt(1, codigoProducto);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                producto = new MProducto();
                producto.setId_producto(rs.getInt("id_pro"));
                producto.setNombre_producto(rs.getString("nom_pro"));
                producto.setDescripcion_producto(rs.getString("des_pro"));
                producto.setStock_producto(rs.getInt("stock_pro"));
                producto.setPrecio_producto(rs.getDouble("precio_pro"));
            }
        }catch(SQLException sq){
            System.out.println("Error al buscar el producto");
            System.out.println(sq.getMessage());
            producto = null;
        }finally{
            try{
                rs.close();
                ps.close();
                con.close();
                
            }catch(Exception e){
                System.out.println("No se encontró la clase");
                System.out.println(e.getMessage());
            }
        }
        return producto;
    }
    
    //creamos un metodo booelano para ir actualizando el stock conforme se realizan las compras
    public boolean actualizarStock(Vector<MProducto> vp){
        boolean actualizo = false;
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConexion();
            for(MProducto producto : vp){
                String q = "UPDATE MProducto SET stock_pro = ? "
                        + "WHERE id_pro = ?";
                ps = con.prepareStatement(q);
                
                ps.setInt(1, producto.getStock_producto());
                ps.setInt(2, producto.getId_producto());
                
                if(ps.executeUpdate() == 1){
                    actualizo = true;
                }else{
                    actualizo = false;
                    break;
                }
            }
            
        }catch(SQLException sq){
            System.out.println("Error al actualizar el stock del producto");
            System.out.println(sq.getMessage());
            actualizo = false;
        }finally{
            try{
                ps.close();
                con.close();
                
            }catch(Exception e){
                System.out.println("No se encontró la clase");
                System.out.println(e.getMessage());
            }
        }
        return actualizo;       
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public InputStream getFoto_producto() {
        return foto_producto;
    }

    public void setFoto_producto(InputStream foto_producto) {
        this.foto_producto = foto_producto;
    }

    public int getStock_producto() {
        return stock_producto;
    }

    public void setStock_producto(int stock_producto) {
        this.stock_producto = stock_producto;
    }

    public double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }

    
}
