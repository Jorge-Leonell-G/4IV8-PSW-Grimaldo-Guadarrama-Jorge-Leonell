<%-- 
    Document   : editarproducto
    Created on : 3/05/2021, 10:58:03 AM
    Author     : rash2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*, java.util.*, java.text.* " %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Prodcuto</title>
    </head>
    <body>
        
        
        <h1>Actualización del producto</h1>
        <br>
        <form method="get" name="formularioeditar" action="actualizarproducto.jsp" >
        <table border="2" width="100%" >
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
                       
                        q = "select id_hel, nom_hel, sab_hel, cos_hel from Cproducto where id_hel="+id;
                        rs = set.executeQuery(q);
                        while(rs.next()){
                            %>
        <tr>
                <td>ID</td>
                <td> <input type="hidden" name="id2" value="<%=rs.getInt("id_hel")%> " </td>
            </tr>
            <tr>
                <td>Nombre del Helado</td>
                <td> <input type="text" name="helado2" value="<%=rs.getString("nom_hel")%> " > </td>
            </tr>
            <tr>
                <td>Sabor del Helado</td>
                <td><input type="text" name="sabor2" value="<%=rs.getString("sab_hel")%> " > </td>
            </tr>
            <tr>
                <td>Costo del Helado</td>
                <td> <input type="number" name="costo2" value="<%=rs.getFloat("cos_hel")%> " > </td>
            </tr>
      
                            <%
                        }
                        rs.close();
                        set.close();
                            
                   }catch(SQLException ed){
                       System.out.println("Error, no se puede leer la tabla");
                       System.out.println(ed.getMessage());
                       
                       %>
        <tr>
                <td>ID</td>
                <td> <input type="hidden" name="id2" value="<%=rs.getInt("id_usu")%> " </td>
            </tr>
            <tr>
                <td>Nombre del Helado</td>
                <td> <input type="text" name="helado2" value="<%=rs.getString("nom_hel")%> " > </td>
            </tr>
            <tr>
                <td>Sabor del Helado</td>
                <td><input type="text" name="sabor2" value="<%=rs.getString("sab_hel")%> " > </td>
            </tr>
            <tr>
                <td>Costo del Helado</td>
                <td> <input type="number" name="costo2" value="<%=rs.getFloat("cos_hel")%> " > </td>
            </tr>
            
                            <%
                       
                   }
                   con.close();
                   
               }catch(Exception e){
                   System.out.println("Error al conectar la Base de Datos");
                   System.out.println(e.getMessage());
                   System.out.println(e.getStackTrace());
                   
                   %>
                    <br>
                    <h1>Sitio en construcción</h1>        
                    <%
               }
            %>
            
            
            
        </table>
        </form>
        
    </body>
</html>
