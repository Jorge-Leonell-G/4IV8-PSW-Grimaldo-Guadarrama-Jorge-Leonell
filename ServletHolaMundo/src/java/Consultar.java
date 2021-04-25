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
public class Consultar extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Consulta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Consulta at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Consulta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tabla General de Usuarios</h1>");
            /*
            creacion de tabla mediante codigo html para que el usuario 
            la visualize, junto con su nombre completo
            */
            out.println("<table border='2' >"
                    + "<thead>"
                        + "<tr><th>ID</th>"
                        + "<th>Nombre Completo</th>"
                        + "<th>Edad</th>"
                        + "<th>Email</th></tr>"
                    + "</thead>");
            try{
                //codigo java para la consulta
                //para ello necesitamos las variables de nuestro servlet Registro
                
                //variables
                String nom, appat, apmat, correo;
                int edad, id;
                
                //tenemos que crear la query (consulta)
                String q = "select * from mregistro";
                //creamos nuestra sentencia
                set = con.createStatement();
                //con rs podemos realizar las consultas 
                rs = set.executeQuery(q);
                
                //necesitamos saber cuantos registros tenemos
                //asi que recorreremos todos nuestros registros a traves de un bucle while
                while(rs.next()){
                    //mientras exista un registro, hay que obtener los datos de la consulta
                    id = rs.getInt("id_usu");
                    nom = rs.getString("nom_usu");
                    appat = rs.getString("appat_usu");
                    apmat = rs.getString("apmat_usu");
                    edad = rs.getInt("edad_usu");
                    correo = rs.getString("correo_usu");
                    
                    out.println("<tbody>"
                            + "<tr><td>"+id+"</td>"
                            + "<td>"+nom+" "+appat+" "+apmat+"</td>"
                            + "<td>"+edad+"</td>"
                            + "<td>"+correo+"</td></tr>"
                            + "</tbody>");
                }
                //hay que cerrar los hilos (threads)
                rs.close();
                set.close();
                
                System.out.println("Consulta Exitosa");
                
            }catch(Exception e){
                System.out.println("Error al realizar la consulta");
                //mesnajes de error y de donde proviene
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                
            }
            
            out.println("</table>");
            
            
            out.println("<br>"
                    + "<a href='index.html'>Regresar a la página principal</a>"
                    + "<br>"
                    + "<a href='Registro'>Insertar Nuevo Usuario</a>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    /*
    momento de crear un destructor
    el destructor libera las conexiones y la memoria de las variables
    */
    public void destroy(){
        try{
            //traemos a nuestro objeto con para cerrar la coneccion
            con.close();
            System.out.println("PUM! Destruido (Consultar)");
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
