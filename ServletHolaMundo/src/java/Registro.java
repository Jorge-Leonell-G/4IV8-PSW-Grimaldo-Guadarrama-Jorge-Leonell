/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rash2
 */
public class Registro extends HttpServlet {
    
    //variables globales para poder manipular la database
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //Constructor del servlet
    //nos va a ayudar a inicializar la conexion con la database
    public void init(ServletConfig cfg) throws ServletException{
        
        //lo primero que necesitamos es trazar la ruta al servidor de la database
        //utilizaremos nuestro driver para conocer la ruta
        String URL = "jdbc:mysql:3306//localhost/registro4iv8";
        //driver:gestor:puerto//IP/nombreBD
        
        String userName = "root";
        String password = "Shellframex731--";
        
        try{
            //colocamos el tipo de driver
            Class.forName("com.mysql.jdbc.Driver");
                        //puerto.gestorBD.tipoConector.Driver
            
            /*
            en algunas ocasiones se envia un error al conectarse con la BD
            y eso se debe a que ya se encuentra integrado el puerto en el driver
            URL = "jdbc:mysql://localhost/registro4iv8"
            */
            
            URL = "jdbc:mysql://localhost/registro4iv8";
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            System.out.println("Conexión exitosa");
            
        }catch(Exception e){
            
            System.out.println("Conexión NO exitosa");
            System.out.println(e.getMessage()); //visualizacion del error
            System.out.println(e.getStackTrace()); //de donde partió el error
            
        }
    }
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request Sirve para las peticiones del cliente
     * @param response servlet response Sirve para dar respuestas por parte del servidor
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //variables
            String nom, appat, apmat, correo, ip, iph;
            int edad, puerto, puertoh;
            
            nom = request.getParameter("nombre");
            appat = request.getParameter("appat");
            apmat = request.getParameter("apmat");
            correo = request.getParameter("correo");
          
            edad = Integer.parseInt(request.getParameter("edad"));
            
            ip = request.getLocalAddr();
            puerto = request.getLocalPort();
            
            iph = request.getRemoteAddr();
            puertoh = request.getRemotePort();
            
            /*
            Una vez que tengamos los datos, vamos a insertarlos en la database
            Para eso necesitamos una query
            insert into nombretabla(definicion atributo, definicion atributo, ...)
            values("valores_cadena", valores_numericos, ...);
            */
            
            try{
                
                String q = "insert into Mregistro (nom_usu,appat_usu,"
                        + "apmat_usu, edad_usu, correo_usu)"
                        + "values ('"+nom+"','"+appat+"','"+apmat+"',"+edad+",'"+correo+"')";
                        //variables
                
                //ejecutar la sentencia
                set.executeUpdate(q);
                
                System.out.println("Registro exitoso");
                
                
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>"
                    + "Tu nombre es: " + nom);
            out.println("<br>"
                    + "Tu apellido paterno es: " + appat
                    + "<br>"
                    + "Tu apellido materno es:" + apmat
                    + "<br>"
                    + "Tu edad es: " + edad
                    + "<br>"
                    + "Tu correo electrónico es: " + correo);
            out.println("<br>"
                    + "IP local: " + ip
                    + "<br>"
                    + "Puerto local: " + puerto
                    + "<br>"
                    + "IP remota: " + iph
                    + "<br>"
                    + "Puerto remoto: " + puertoh);
            out.println("<h1>Registro Exitoso</h1>"
                    + "<a href='index.html'>Regresar a la página principal</a>");
            out.println("</body>");
            out.println("</html>");
            
            }catch(Exception e){
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Registro</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Registro NO Exitoso, vuelva a intentarlo</h1>"
                    + "<a href='index.html'>Regresar a la página principal</a>");
                out.println("</body>");
                out.println("</html>");
                
                System.out.println("No se registró en la tabla");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                
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
