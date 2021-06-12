/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.DCompra;
import Modelo.MUsuario;
import Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leone
 */
public class AgregarCarrito extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            //necesitamos obtener nuestra sesión
            HttpSession sesionuok = request.getSession();
            
            //generar el vector del detalle del carrito para saber que estamos agregando
            Vector<DCompra> vectorDetalle = null;
            
            //necesitamos saber como está el stock al momento para luego restarlo
            
            Vector<Producto> stockProducto = null;
            
            //si se creo la sesion con el atributo del detalle de la venta
            
            if(sesionuok.getAttribute("detalleVenta") != null){
                //si existe una sesion con ese atributo y hay que obtener los datos
                //de detalle de la compra que está realizando el usuario
                vectorDetalle = (Vector<DCompra>)sesionuok.getAttribute("detalleVenta");
                stockProducto = (Vector<Producto>)sesionuok.getAttribute("stockProducto");
            }else{
                //no existe esa sesion y se crean por primera vez los carritos
                vectorDetalle = new Vector<DCompra>();
                stockProducto = new Vector<Producto>();
            }
            
            
            //obtener que producto se está seleccionando
            int codigo, cantidad;
            codigo = Integer.parseInt(request.getParameter("txtCodigo").trim());
            cantidad = Integer.parseInt(request.getParameter("txtCantidad").trim());
            
            Producto producto = new Producto();
            
            producto = producto.buscarProducto(codigo);
            
            //vamos a hacer la opreacion de cálculo de subtotal y total
            double subtotal = cantidad * producto.getPrecio_producto();
            
            //tenemos que crear el objeto de la clase MUsuario
            MUsuario usuario = new MUsuario();
            
            //creamos el detalle de la compra
            DCompra detallecompra = new DCompra();
            
            detallecompra.setId_dcompra(vectorDetalle.size()+1);
            detallecompra.setId_producto(codigo);
            detallecompra.setCantidad_compra(cantidad);
            detallecompra.setSubtotal_compra(subtotal);
            detallecompra.setId_ecompra(usuario.getId_usuario());
            
            //agrego el detalle de la venta al vector detalle
            vectorDetalle.add(detallecompra);
            
            sesionuok.setAttribute("detalleVenta", vectorDetalle);
            
            //agregar el stock actualizado al producto
            
            producto.setStock_producto(producto.getStock_producto() - cantidad);
            
            stockProducto.add(producto);
            
            sesionuok.setAttribute("stockProducto", stockProducto);
            
            response.sendRedirect("carrito.jsp");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarCarrito</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarCarrito at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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