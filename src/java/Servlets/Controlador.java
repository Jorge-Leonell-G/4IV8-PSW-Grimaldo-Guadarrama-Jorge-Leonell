/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.Carrito;
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leone
 */
public class Controlador extends HttpServlet {
    
    ProductoDAO pdao = new ProductoDAO();
    Producto p = new Producto();
    List<Producto> productos = new ArrayList();
    
    List<Carrito> listaCarrito = new ArrayList();
    int item;
    double totalPagar = 0.0;
    int cantidad = 1;
    
    //declaracion de variables globales
    int idp;
    Carrito car;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String accion = request.getParameter("accion");
            
        productos = pdao.listar();
        switch(accion){
            case "Comprar":
                totalPagar = 0.0;
                //Para este caso, es lo mismo que agregarCarrito y Carrito pero unificados
                int idp = Integer.parseInt(request.getParameter("id"));
                p = pdao.listarId(idp);
                item += 1;
                Carrito car = new Carrito();
                car.setItem(item);
                car.setIdProducto(p.getId_producto());
                car.setNombres(p.getNombre_producto());
                car.setDescripcion(p.getDescripcion_producto());
                car.setPrecioCompra(p.getPrecio_producto());
                car.setCantidad(cantidad);
                car.setSubtotal((int)(cantidad * p.getPrecio_producto()));
                listaCarrito.add(car);
                for (int i = 0; i < listaCarrito.size(); i++){
                    totalPagar = totalPagar + listaCarrito.get(i).getSubtotal();
                    request.setAttribute("totalPagar", totalPagar);
                }
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
                
            case "AgregarCarrito":
                int pos = 0;
                cantidad = 1;
                idp = Integer.parseInt(request.getParameter("id"));
                p = pdao.listarId(idp);
                if(listaCarrito.size() > 0){
                    for (int i = 0; i <listaCarrito.size(); i++){
                        if(idp==listaCarrito.get(i).getIdProducto()){
                            pos = i;
                        }
                    }
                    if(idp == listaCarrito.get(pos).getIdProducto()){
                        cantidad = listaCarrito.get(pos).getCantidad() + cantidad;
                        double subtotal = listaCarrito.get(pos).getPrecioCompra() * cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubtotal((int) subtotal);
                    }else{
                        //agregamos el producto con normalidad
                        item = item + 1;
                        car = new Carrito();
                        car.setItem(item);
                        car.setIdProducto(p.getId_producto());
                        car.setNombres(p.getNombre_producto());
                        car.setDescripcion(p.getDescripcion_producto());
                        car.setPrecioCompra(p.getPrecio_producto());
                        car.setCantidad(cantidad);
                        car.setSubtotal((int)(cantidad * p.getPrecio_producto()));
                        listaCarrito.add(car);
                    }
                }else{
                    item = item + 1;
                    car = new Carrito();
                    car.setItem(item);
                    car.setIdProducto(p.getId_producto());
                    car.setNombres(p.getNombre_producto());
                    car.setDescripcion(p.getDescripcion_producto());
                    car.setPrecioCompra(p.getPrecio_producto());
                    car.setCantidad(cantidad);
                    car.setSubtotal((int)(cantidad * p.getPrecio_producto()));
                    listaCarrito.add(car);
                }
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
                break;
                
            case "Carrito":
                totalPagar = 0.0;
                request.setAttribute("carrito", listaCarrito);
                for (int i = 0; i < listaCarrito.size(); i++){
                    totalPagar = totalPagar + listaCarrito.get(i).getSubtotal();
                    request.setAttribute("totalPagar", totalPagar);
                }
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
                
            default:
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
        }
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}