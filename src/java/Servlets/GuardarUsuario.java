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
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leone
 */
public class GuardarUsuario extends HttpServlet {

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
            
            /*
            Generar la sesión del usuario
            */
            
            HttpSession sesionuok = request.getSession(true);
            
            //creacion de "cookie" (hashmap)
            
            Integer cuenta = (Integer)sesionuok.getAttribute("cuenta.ss");
            
            String idsesion = sesionuok.getId();
            
            long fechacreacion = sesionuok.getCreationTime();
            
            long fechaultimoacceso = sesionuok.getLastAccessedTime();
            
            //primera vez que se ingresa
            if(cuenta == null){
                cuenta = new Integer(1);
            }else{
                cuenta = new Integer(cuenta.intValue()+1);
            }
            
            sesionuok.setAttribute("cuenta.ss", cuenta);
            
            //impresion de los valores de la sesion
            System.out.println("ID de la sesión: " + idsesion);
            System.out.println("Fecha de creación: " + new Date(fechacreacion).toString());
            System.out.println("Fecha de último acceso: " + new Date(fechaultimoacceso).toString());
            
            //visualizacion de los parametros del hashmap
            
            Enumeration paramsesion = sesionuok.getAttributeNames();
            
            while(paramsesion.hasMoreElements()){
                String parametros = (String)paramsesion.nextElement();
                Object valor = sesionuok.getAttribute(parametros);
                System.out.println("El parametro es: " + parametros 
                + "Su valor es. " + valor.toString());
            }
            
            String nom, appat, apmat, dir, fechanac, tel, cel, user, pass;
            int formapago, privilegio;
            
            nom = request.getParameter("txtNombre");
            appat = request.getParameter("txtAppat");
            apmat = request.getParameter("txtApmat");
            dir = request.getParameter("txtDir");
            fechanac = request.getParameter("txtFechanac");
            tel = request.getParameter("txtTel");
            cel = request.getParameter("txtCel");
            formapago = Integer.parseInt(request.getParameter("txtFormapago"));
            user = request.getParameter("txtUser");
            pass = request.getParameter("txtPass");
            privilegio = Integer.parseInt(request.getParameter("txtPrivilegio"));
            
            //instancia del usuario
            MUsuario u = new MUsuario();
            
            u.setNombre_usuario(nom);
            u.setAppat_usuario(appat);
            u.setApmat_usuario(apmat);
            u.setDir_usuario(dir);
            u.setFechanac_usuario(fechanac);
            u.setTel_usuario(tel);
            u.setCel_usuario(cel);
            u.setId_formapago(formapago);
            u.setUser_usuario(user);
            u.setPass_usuario(pass);
            u.setPrivilegio_usuario(privilegio);
            
            int status = AccionesUsuario.registrarUsuario(u);
            
            if(status > 0){
                response.sendRedirect("registrousuarios.jsp");
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
