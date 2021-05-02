<%-- 
    Document   : editar
    Created on : 2/05/2021, 02:14:50 PM
    Author     : rash2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*, java.util.*, java.text.* " %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Registro</title>
    </head>
    <body>
        
        
        
        
        
        
        <h1>Actualización del perfil</h1>
        <br>
        <form method="get" name="formularioeditar" action="actualizar.jsp" >
        <table border="2" width="100%" >
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
                   try{
                       set = con.createStatement();
                       //parametros del formulario
                       String q;
                       int id;
                    
                        id = Integer.parseInt(request.getParameter("id"));
                       
                        q = "select id_usu, nom_usu, ciu_usu, tel_usu from registrousuario where id_usu="+id;
                        rs = set.executeQuery(q);
                        while(rs.next()){
                            %>
        <tr>
                <td>ID</td>
                <td> <input type="hidden" name="id2" value="<%=rs.getInt("id_usu")%> " </td>
            </tr>
            <tr>
                <td>Nombre</td>
                <td> <input type="text" name="nombre2" value="<%=rs.getString("nom_usu")%> " > </td>
            </tr>
            <tr>
                <td>Ciudad</td>
                <td><input type="text" name="ciudad2" value="<%=rs.getString("ciu_usu")%> " > </td>
            </tr>
            <tr>
                <td>Teléfono</td>
                <td> <input type="text" name="tel2" value="<%=rs.getString("tel_usu")%> " > </td>
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
                <td>Nombre</td>
                <td> <input type="text" name="nombre2" value="<%=rs.getString("nom_usu")%> " > </td>
            </tr>
            <tr>
                <td>Ciudad</td>
                <td><input type="text" name="ciudad2" value="<%=rs.getString("ciu_usu")%> " > </td>
            </tr>
            <tr>
                <td>Teléfono</td>
                <td> <input type="text" name="tel2" value="<%=rs.getString("tel_usu")%> " > </td>
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
