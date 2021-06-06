<%-- 
    Document   : editarusuario
    Created on : 4/06/2021, 09:16:02 AM
    Author     : rash2
--%>

<%@page import="Modelo.MUsuario"%>
<%@page import="Control.AccionesUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Actualizar Registro de Usuarios</h1>
        <form method="post" name="actualizarDatos" action="ActualizarUsuario" >
            <table border="2" >
                <%
                    //codigo java para la obtencion de datos
                    int id =Integer.parseInt(request.getParameter("id"));
                    
                    MUsuario u = AccionesUsuario.buscarUsuarioById(id);
                    %>
                <tr>
                    <td>ID:</td>
                    <td> <input type="hidden" name="id2" value="<%=u.getId_usuario()%> "> </td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td> <input type="text" name="txtNombre2" size="25"
                                    value="<%=u.getNombre_usuario()%> "> </td>
                </tr>
                <tr>
                    <td>Apellido Paterno:</td>
                    <td> <input type="text" name="txtAppat2" size="15"
                                    value="<%=u.getAppat_usuario()%> "> </td>
                </tr>
                <tr>
                    <td>Apellido Materno:</td>
                    <td> <input type="text" name="txtApmat2" size="15"
                                    value="<%=u.getApmat_usuario()%> "> </td>
                </tr>
                <tr>
                    <td>ID Dirección:</td>
                    <td> <input type="number" name="txtDir2"
                                    value="<%=u.getId_dir()%> "> </td>
                </tr>
                <tr>
                    <td>Fecha de Nacimiento:</td>
                    <td> <input type="date" name="txtFechanac2"> </td>
                </tr>
                <tr>
                    <td>Número de Teléfono Particular:</td>
                    <td> <input type="text" name="txtTel2" size="10"
                                    value="<%=u.getTel_usuario()%> "> </td>
                </tr>
                <tr>
                    <td>Número de Teléfono Celular:</td>
                    <td> <input type="text" name="txtCel2" size="8"
                                    value="<%=u.getCel_usuario()%> "> </td>
                </tr>
                <tr>
                    <td>Forma de Pago:</td>
                    <td> <input type="number" name="txtFormapago2"
                                value="<%=u.getId_formapago()%> "> </td>
                </tr>
                <tr>
                    <td>Usuario:</td>
                    <td> <input type="text" name="txtUser2" size="12" 
                                value="<%=u.getUser_usuario()%>"> </td>
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td> <input type="password" name="txtPass2" size="8" 
                                value="<%=u.getPass_usuario()%>"> </td>
                </tr>
                <tr>
                    <td>Privilegio:</td>
                    <td> <input type="number" name="txtPrivilegio2" 
                                    value="<%=u.getPrivilegio_usuario()%>"> </td>
               </tr>
               <tr>
                   <td colspan="2" > <input type="submit"
                                            value="Actualizar al Usuario"> </td>
               </tr>
            </table>
        </form>
    </body>
</html>
