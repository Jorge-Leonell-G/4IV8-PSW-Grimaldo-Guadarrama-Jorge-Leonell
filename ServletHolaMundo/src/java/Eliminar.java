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
public class Eliminar extends HttpServlet {

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
            
            //para eliminar a un usuario requerimos de su llave primaria, es decir, de su ID
            int id;
            
            id = Integer.parseInt(request.getParameter("ideliminar"));
            
            //preparamos nuestra sentencia
            //delete from tabla where atributo = valor
            
            String q = "delete from mregistro where id_usu ="+id;
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Eliminar</title>");            
            out.println("</head>");
            out.println("<body>");
            //codigo try catch
            try{
                set.executeUpdate(q);
                System.out.println("Registro Eliminado");
                out.println("<h1>Usuario Eliminado</h1>");
                set.close();
                rs.close();
            }catch(Exception e){
                System.out.println("<h1>Usuario NO Eliminado</h1>");
                System.out.println("No se pudo eliminar el usuario");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            
            
            
            out.println("<br>"
                    + "<a href='index.html'>Regresar a la página principal</a>"
                    + "<br>"
                    + "<a href='Registro'>Insertar Nuevo Usuario</a>"
                    + "<br>"
                    + "<a href='Consultar'>Consultar Tabla General de Usuarios</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
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
