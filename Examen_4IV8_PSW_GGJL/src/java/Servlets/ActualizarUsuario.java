/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Control.AccionesUsuario;
import Modelo.MUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rash2
 */
public class ActualizarUsuario extends HttpServlet {

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
            
            //obtencion de parametros
            String nom, appat, apmat, fechanac, tel, cel, user, pass;
            int dir, formapago, privilegio;
            
            int id =Integer.parseInt(request.getParameter("id2"));
            
            nom = request.getParameter("txtNombre2");
            appat = request.getParameter("txtAppat2");
            apmat = request.getParameter("txtApmat2");
            dir = Integer.parseInt(request.getParameter("txtDir2"));
            fechanac = request.getParameter("txtFechanac2");
            tel = request.getParameter("txtTel2");
            cel = request.getParameter("txtCel2");
            formapago = Integer.parseInt(request.getParameter("txtFormapago2"));
            user = request.getParameter("txtUser2");
            pass = request.getParameter("txtPass2");
            privilegio = Integer.parseInt(request.getParameter("txtPrivilegio2"));
            
            
            MUsuario u = new MUsuario();
            
            u.setId_usuario(id);
            u.setNombre_usuario(nom);
            u.setAppat_usuario(appat);
            u.setApmat_usuario(apmat);
            u.setId_dir(dir);
            u.setFechanac_usuario(fechanac);
            u.setTel_usuario(tel);
            u.setCel_usuario(cel);
            u.setId_formapago(formapago);
            u.setUser_usuario(user);
            u.setPass_usuario(pass);
            u.setPrivilegio_usuario(privilegio);
            
            int status = AccionesUsuario.actualizarUsuario(u);
            
            if(status > 0){
                response.sendRedirect("MostrarUsuarios.jsp");
            }else{
                response.sendRedirect("error.jsp");
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
