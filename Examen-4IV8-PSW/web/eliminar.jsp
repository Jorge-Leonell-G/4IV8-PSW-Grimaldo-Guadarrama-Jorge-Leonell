<%-- 
    Document   : eliminar
    Created on : 2/05/2021, 06:22:43 PM
    Author     : rash2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*, java.util.*, java.text.* " %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Registro</title>
    </head>
    <body>
        <%
        //aqui ya puedo incorporar codigo java
        Connection con = null;
        Statement set = null;
        ResultSet rs = null;

        String url, username, password, driver;

        url = "jdbc:mysql://us-cdbr-east-03.cleardb.com/heroku_7585192c80d48c9";
        username = "ba1d4a0655e960";
        password = "562e50e0";
        driver = "com.mysql.jdbc.Driver";
        
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            
            try{
                    set = con.createStatement();
                    //parametros del formulario
                    String q;
                    int id;
                    
                    id = Integer.parseInt(request.getParameter("id"));
                    q = "delete from Cusuario where id_usu="+id;
                    
                    
                    int eliminar = set.executeUpdate(q);
                    
                    %>
                    <h1>Registro Eliminado con Éxito</h1>
                    <%
                        set.close();
                            
            }catch(SQLException ed){
                System.out.println("Error al elimnar el registro en la tabla");
                System.out.println(ed.getMessage());
                %>
                    <h1>:(</h1>
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
