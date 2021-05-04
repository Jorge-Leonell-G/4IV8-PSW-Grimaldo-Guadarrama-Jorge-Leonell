<%-- 
    Document   : actualizarproducto
    Created on : 3/05/2021, 10:51:03 AM
    Author     : rash2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*, java.util.*, java.text.* " %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Producto</title>
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
                    
                    String helado, sabor;
                    float costo;
                
                    helado = request.getParameter("helado2");
                    sabor = request.getParameter("sabor2");
                    costo = Float.parseFloat(request.getParameter("costo2"));
                    
                    id = Integer.parseInt(request.getParameter("id2"));
                    q = "update Cproducto set nom_hel = '"+helado+"', sab_hel = '"+sabor+"', "
                            + "cos_hel = '"+costo+"' where id_hel = "+id+" " ;
                    
                    
                    int actualizar = set.executeUpdate(q);
                    
                    %>
                    <h1>Datos Actualizados con Éxito</h1>
                    <%
                        set.close();
                            
            }catch(SQLException ed){
                System.out.println("Error al actualizar el producto en la tabla");
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
