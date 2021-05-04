<%-- 
    Document   : guardar
    Created on : 2/05/2021, 06:47:08 PM
    Author     : rash2
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*, java.util.*, java.text.* " %>
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
        
        url = "jdbc:mysql://localhost/registroexamen";
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
                String nombre, appat, apmat, dom, q;
                int edad, fecha, telpart, telcel;
                
                nombre = request.getParameter("nombre");
                appat = request.getParameter("appat");
                apmat = request.getParameter("apmat");
                edad = Integer.parseInt(request.getParameter("edad"));
                fecha = Integer.parseInt(request.getParameter("fecha"));
                dom = request.getParameter("dom");
                telpart = Integer.parseInt(request.getParameter("telpart"));
                telcel = Integer.parseInt(request.getParameter("telcel"));
                
                
                //creacion de query
                q = "insert into Cusuario(nom_usu, appat_usu, apmat_usu, edad_usu, fecha_usu, dom_usu, telpart_usu, telcel_usu) "
                        + "values ('"+nombre+"', '"+appat+"', '"+apmat+"', "+edad+", "+fecha+", '"+dom+"', "+telpart+", "+telcel+" )";
                
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
