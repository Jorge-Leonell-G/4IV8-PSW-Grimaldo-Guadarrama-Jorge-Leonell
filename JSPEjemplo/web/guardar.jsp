<%-- 
    Document   : guardar
    Created on : 2/05/2021, 11:33:27 AM
    Author     : rash2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*, java.util.*, java.text.* " %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <%
        //aqui ya puedo incorporar codigo java
        Connection con = null;
        Statement set = null;
        ResultSet rs = null;
        
        String url, username, password, driver;
        
        url = "jdbc:mysql://localhost/registro";
        username = "root";
        password = "Shellframex731--";
        driver = "com.mysql.jdbc.Driver";
        
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            
            //diferentes vistas para los errores
            //error exclusivo de mysql
            try{
                set = con.createStatement();
                //parametros del formulario
                String nombre, ciudad, tel, q;
                
                nombre = request.getParameter("nombre");
                ciudad = request.getParameter("ciudad");
                tel = request.getParameter("tel");
                
                //creacion de query
                q = "insert into registrousuario(nom_usu, ciu_usu, tel_usu) "
                        + "values ('"+nombre+"', '"+ciudad+"', '"+tel+"')";
                
                int registro = set.executeUpdate(q);
                %>
                <h1>Registro Exitoso</h1>
             <%
                set.close();
            }catch(SQLException ed){
                System.out.println("Error al registrar en la tabla");
                System.out.println(ed.getMessage());
                
                %>
                <h1>Registro NO Exitoso, error en la lectura de la tabla</h1>
                <%
                
            }
            con.close();
            
         //error general
        }catch(Exception e){
            System.out.println("Error al conectar la Basede Datos");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            %>
            <h1>Sitio en Construcción</h1>
            <%
        }
                        
        
            %>
        
        
        <a href="index.html">Regresar a la Página Principal</a>
    </body>
</html>
