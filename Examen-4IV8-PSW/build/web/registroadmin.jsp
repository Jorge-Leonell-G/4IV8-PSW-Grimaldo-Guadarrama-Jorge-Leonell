<%-- 
    Document   : registroadmin
    Created on : 2/05/2021, 07:43:56 PM
    Author     : rash2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*, java.util.*, java.text.* " %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Productos</title>
        <link rel="stylesheet" href="./CSS/registroestilo.css">
    </head>
    <body>
    <script src="./JS/registrovalidacion.js"></script>
        <main>
        <div class="container" >
            <div class="div-datos">
                <form method="post" id="form" name="formulario" action="guardarproducto.jsp" onsubmit="return validarAlertas(event)">
                <h3>Registrar</h3>
                <div class="container">
                    <input type="text" name="helado" placeholder="Nombre del helado" required maxlength="20" onkeypress="return validarNombre(event)">
                </div>
                <div class="container">
                    <input type="text" name="sabor" placeholder="Sabor" required maxlength="15" onkeypress="return validarNombre(event)">
                </div>
                <div class="container">
                    <input type="number" name="costo" placeholder="Costo" required maxlength="3" onkeypress="return validarCosto(event)">
                </div>
                <input type="submit" value="Registrar Producto" name="enviar" onclick="return validarAlertas()">
                <br>
                <input type="reset" value="Eliminar Datos" name="eliminar" >
            </form>
            </div> 
        </div>
    </main>
    </body>
</html>
