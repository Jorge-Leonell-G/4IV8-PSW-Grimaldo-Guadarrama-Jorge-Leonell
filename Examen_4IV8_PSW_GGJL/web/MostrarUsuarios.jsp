<%-- 
    Document   : MostrarUsuarios
    Created on : 4/06/2021, 08:45:43 AM
    Author     : rash2
--%>

<%@page import="java.util.List"%>
<%@page import="Control.AccionesUsuario"%>
<%@page import="Modelo.MUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla General de Usuarios</h1>
        <br>
        <table border="2" >
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido Paterno</th>
                    <th>Apellido Materno</th>
                    <th>Dirección</th>
                    <th>Fecha de nacimiento</th>
                    <th>Teléfono particular</th>
                    <th>Teléfono celular</th>
                    <th>Privilegio</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                 //generamos un objeto de lista
                List<MUsuario> lista = AccionesUsuario.buscarAllUsuarios();
                    
                for(MUsuario u : lista){
                        
                    %>
                    <tr>
                        <td><%=u.getId_usuario()%></td>
                        <td><%=u.getNombre_usuario()%></td>
                        <td><%=u.getAppat_usuario()%></td>
                        <td><%=u.getApmat_usuario()%></td>
                        <td><%=u.getId_dir()%></td>
                        <td><%=u.getFechanac_usuario()%></td>
                        <td><%=u.getTel_usuario()%></td>
                        <td><%=u.getCel_usuario()%></td>
                        <td><%=u.getPrivilegio_usuario()%></td>
                        <td> <a href="editarusuario.jsp?id=<%=u.getId_usuario()%>" >Editar</a> </td>
                        <td> <a href="BorrarUsuario?id=<%=u.getId_usuario()%>" >Borrar</a> </td>
                    </tr>
                    <%
                    
                    
                    }
                %>
            </tbody>
        </table>
        <br>
        <a href="index.html">Regresar al menú principal</a>
    </body>
</html>
