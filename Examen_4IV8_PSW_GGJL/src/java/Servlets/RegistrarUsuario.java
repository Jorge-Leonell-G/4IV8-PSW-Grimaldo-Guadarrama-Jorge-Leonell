/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Control.Conexion;
import Modelo.MUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rash2
 */
public class RegistrarUsuario extends HttpServlet {

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
            
            //antes que nada, generamos el objeto de nuestro usuario
            MUsuario u = new MUsuario();
            
            int status = 0;
            try{
                Connection con = Conexion.getConexion();
                String q = "INSERT INTO MUsuario (nom_usu, appat_usu, apmat_usu, "
                        + "id_dir, fechanac_usu, tel_usu, cel_usu, id_formapago, user_usu, "
                        + "pass_usu, privilegio_usu)"
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                PreparedStatement ps = con.prepareStatement(q);
                
                //getters y setters
                ps.setString(1, u.getNombre_usuario());
                ps.setString(2, u.getAppat_usuario());
                ps.setString(3, u.getApmat_usuario());
                ps.setInt(4, u.getId_dir());
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
            
            
            
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrarEmpleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarEmpleado at " + request.getContextPath() + "</h1>");
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
