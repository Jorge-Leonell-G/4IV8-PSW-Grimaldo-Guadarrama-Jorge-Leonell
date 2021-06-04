<%-- 
    Document   : CarritoHelado
    Created on : 3/06/2021, 10:40:36 AM
    Author     : rash2
--%>

<%@page import="Modelo.DCompra"%>
<%@page import="Modelo.MProducto"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>

<%
    String usuario = "";
    HttpSession sesionuok = request.getSession();
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
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
           //necesitamos obtener primero nuestro carro
            Vector<DCompra> vectorDetCompra = 
                    (Vector<DCompra>)sesionuok.getAttribute("detalleVenta"); 
            
            %>
        
        
        
        <h1>Productos que ha seleccionado</h1>
    </body>
</html>
