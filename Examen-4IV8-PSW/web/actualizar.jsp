<%-- 
    Document   : actualizar
    Created on : 2/05/2021, 06:44:08 PM
    Author     : rash2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*, java.util.*, java.text.* " %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Datos</title>
    </head>
    <body>
        
        
        <%
        //aqui ya puedo incorporar codigo java
        Connection con = null;
        Statement set = null;
        ResultSet rs = null;

        String url, username, password, driver;

        url = "jdbc:mysql://localhost/registroexamen";
        username = "root";
        password = "Shellframex731--";
        driver = "com.mysql.jdbc.Driver";
        
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            
            try{
                    set = con.createStatement();
                    //parametros del formulario
                    String q;
                    int id;
                    
                    String nombre, appat, apmat, dom;
                    int edad, fecha, telpart, telcel;
                
                    nombre = request.getParameter("nombre2");
                    appat = request.getParameter("appat2");
                    apmat = request.getParameter("apmat2");
                    edad = Integer.parseInt(request.getParameter("edad2"));
                    fecha = Integer.parseInt(request.getParameter("fecha2"));
                    dom = request.getParameter("dom2");
                    telpart = Integer.parseInt(request.getParameter("telpart2"));
                    telcel = Integer.parseInt(request.getParameter("telcel2"));
                    
                    id = Integer.parseInt(request.getParameter("id2"));
                    q = "update Cusuario set nom_usu = '"+nombre+"', appat_usu = '"+appat+"', "
                            + "apmat_usu = '"+apmat+"',  edad_usu = "+edad+", fecha_usu = "+fecha+", dom_usu = '"+dom+"', "
                            + "telpart_usu = "+telpart+", telcel_usu = "+telcel+" where id_usu = "+id+" " ;
                    
                    
                    int actualizar = set.executeUpdate(q);
                    
                    %>
                    <h1>Datos Actualizados con Éxito</h1>
                    <%
                        set.close();
                            
            }catch(SQLException ed){
                System.out.println("Error al actualizar el registro en la tabla");
                System.out.println(ed.getMessage());
                %>
                    <h1>Solo juguito contigo ¬¬ T_T</h1>
                    <%
                
            
        }
        con.close();
            
            
        }catch(Exception e ){
            System.out.println("Error al conectar con la Base de Datos");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            %>
            <br>
            <h1>Sitio en construcción</h1>        
            <%
            
        }
        
        %>
        
        
        <a href="index.html">Regresar a la Página Principal</a>
        
    </body>
</html>
