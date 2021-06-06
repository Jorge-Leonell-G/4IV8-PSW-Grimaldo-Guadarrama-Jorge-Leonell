<%-- 
    Document   : registrousuarios
    Created on : 3/06/2021, 10:03:52 PM
    Author     : rash2
--%>

<%@page import="Modelo.MUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>

<%
    String usuario = "";
    HttpSession sesionuok = request.getSession();
    
    //instancia de la clase MUsuario
    MUsuario u = new MUsuario();
    
    //establecemos nuestro atributo
    sesionuok.setAttribute("usuario", u.getNombre_usuario());
    
    if(sesionuok.getAttribute("usuario")==null){
        
    %>
    <jsp:forward page="index.html" >
        <jsp:param name="error" value="Es obligatorio identificarse" />
        
    </jsp:forward>
    <%
        
    }else{
        //si se identificó
        usuario = (String)sesionuok.getAttribute("usuario");
    }
    %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro del Usuario</title>
    </head>
    <body>
        <h1>¡Registro Exitoso!</h1>
        <br>
        <h2>¡Bienvenido <% out.println(sesionuok.getAttribute("usuario")); %>!</h2>
        <br>
        <a href="index.html">Regresar al menú principal</a>
    </body>
</html>
