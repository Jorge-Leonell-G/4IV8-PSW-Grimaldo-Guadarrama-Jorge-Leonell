<%-- 
    Document   : MostrarHelados
    Created on : 2/06/2021, 05:52:42 PM
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
        <title>Helados Ben & Jerry's</title>
    </head>
    <body>
        
        <br>
        <h1>Botón de cerrar sesion (redireccion a servlet Cerrar sesion) invalidate y regreso a index</h1>
        <br>
        <h2>¡Bienvenido <% out.println(sesionuok.getAttribute("usuario")); %>!</h2>
  
        <%
    
            
            //todos los productos
            Vector<MProducto> vecproducto = new MProducto().listaProductos();
            //necesitamos que nuestro objeto sea polimórfico
            %>
        <h1>Una tabla donde aparezcan todos los productos</h1>
        
        <%
            //recorrer el vector del producto
            for(MProducto producto : vecproducto){
                //voy imprimiendo´producto por producto
            }
            %>
    </body>
</html>
