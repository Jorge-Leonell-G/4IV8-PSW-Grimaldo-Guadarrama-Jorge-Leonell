<%-- 
    Document   : CarritoHelado
    Created on : 3/06/2021, 10:40:36 AM
    Author     : rash2
--%>

<%@page import="Modelo.MUsuario"%>
<%@page import="Modelo.DCompra"%>
<%@page import="Modelo.MProducto"%>
<%@page import="java.util.Vector"%>
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
        <title>Carrito de Compras de Helados</title>
    </head>
    <body>
        <h1>¡Bienvenido <% out.println(sesionuok.getAttribute("usuario")); %>!</h1>
        <br>
        <%
           //necesitamos obtener primero nuestro carro
            Vector<DCompra> vectorDetCompra = 
                    (Vector<DCompra>)sesionuok.getAttribute("detalleVenta"); 
            
            %>
        
        
        
        <h1>Productos que ha seleccionado</h1>
    </body>
</html>
