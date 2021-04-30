/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
Connection nos ayuda a realizar la conexion con las bd, con el servidor
*/
import java.sql.Connection;
import java.sql.DriverManager;
/*
Statement nos ayuda a poder definir y manipular los datos de las bd
creacion de la bd, insertar tablas, eleminar tablas,  create, drop, alter
    manipulacion de los datos, insert, update, delete
*/
import java.sql.Statement;
/*
nos ayuda para las querrys, o las consultas a la bd
*/
import java.sql.ResultSet;
import javax.servlet.ServletConfig;

/**
 *
 * @author rash2
 */
public class Actualizar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            String nom, appat, apmat, correo, ip, iph;
            int edad, id_a;
            
            nom = request.getParameter("nom_n");   
            appat = request.getParameter("appat_n");
            apmat = request.getParameter("appmat_n");
            correo = request.getParameter("correo_n");
            
            
            id_a = Integer.parseInt(request.getParameter("idactualizar"));
                        
            edad = Integer.parseInt(request.getParameter("Edad_n"));
            
            try{
                //creamos nuestra sentencia a ejecutar
                String q = "UPDATE Mregistro"
                        + "SET  (nom_usu, appat_usu, apmat_usu, edad_usu, correo_usu) "
                        + "values ('"+nom+"', '"+appat+"', '"+apmat+"', "+edad+", '"+correo+"')"
                        + "WHERE id_usu values "+id_a+" ";
                
                //ejecutar la sentencia
                set.executeUpdate(q);
                
                System.out.println("Registro exitoso");
              
                
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>"
                    + "Su nombre es: " + nom);
            out.println("<br>"
                    + "Su apellido paterno es: " + appat
                    + "<br>"
                    + "Su apellido materno es: " + apmat
                    + "<br>"
                    + "Su edad es: " +edad
                    + "<br>"
                    + "Su correo electronico es:  "+correo);
            out.println("<h1>Registro Exitoso</h1>"
                    + "<a href='index.html'>Regresar a la pagina principal</a>"
                    + "<br>"
                    + "<a href='Consultar'>Consultar Tabla General de Usuarios</a>");
            out.println("</body>");
            out.println("</html>");
                
            }catch(Exception e){
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Actualizar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Actualización NO Realizada, inténtelo de nuevo</h1>"
                    + "<a href='index.html'>Regresar a la Página Principal</a>");
            out.println("</body>");
            out.println("</html>");
            
            System.out.println("Dato NO Actualizado en la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Actualizar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Actualizar at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    //copiamos y pegamos nuestro metodo destructor >:D
    public void destroy(){
        try{
            //traemos a nuestro objeto con para cerrar la coneccion
            con.close();
            System.out.println("PUM! Destruido (Eliminar)");
        }catch(Exception e){
            //si no funciona el try, tramoes a nuestra arma pesada para la destruccion
            super.destroy();
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
