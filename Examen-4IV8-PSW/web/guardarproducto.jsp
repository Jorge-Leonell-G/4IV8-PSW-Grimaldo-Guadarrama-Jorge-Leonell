<%-- 
    Document   : guardarproducto
    Created on : 2/05/2021, 08:47:34 PM
    Author     : rash2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*, java.util.*, java.text.* " %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guardar Producto</title>
    </head>
    <body>
        <%
        //aqui ya puedo incorporar codigo java
        Connection con = null;
        Statement set = null;
        ResultSet rs = null;
        
        String url, username, password, driver;
        
                                    //nombre de la DATABASE
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
                String helado, sabor, q;
                float costo;
                
                helado = request.getParameter("helado");
                sabor = request.getParameter("sabor");
                costo = Float.parseFloat(request.getParameter("costo"));
                
                
                //creacion de query
                q = "insert into Cproducto(nom_hel, sab_hel, cos_hel) "
                        + "values ('"+helado+"', '"+sabor+"', '"+costo+"' )";
                
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
        <a href='consultarproducto.jsp'>Consulta General de Productos</a>
        
    </body>
</html>
