<%-- 
    Document   : consultar
    Created on : 2/05/2021, 06:14:58 PM
    Author     : rash2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*, java.util.*, java.text.* " %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta</title>
    </head>
    <body>
        <h1>Tabla General de Registro</h1>
        <div class="containerTable" >
            <table border="2" width="100%" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido Paterno</th>
                        <th>Apellido Materno</th>
                        <th>Edad</th>
                        <th>Fecha de Nacimiento</th>
                        <th>Domicilio</th>
                        <th>Teléfono Particluar</th>
                        <th>Teléfono Celular</th>
                    </tr>
                </thead>
                <tbody>
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
                            
                            //sentencia completa
                            q = "select * from Cusuario order by nom_usu asc";
                            
                            rs = set.executeQuery(q);
                            //nuestro bucle while va a imprimir los datos de nuestra tabla
                            while(rs.next()){
                                %>
                                
                <tr>
                    <td><%=rs.getInt("id_usu")%> </td>
                    <td><%=rs.getString("nom_usu")%></td>
                    <td><%=rs.getString("appat_usu")%></td>
                    <td><%=rs.getString("apmat_usu")%></td>
                    <td><%=rs.getInt("edad_usu")%></td>
                    <td><%=rs.getInt("fecha_usu")%></td>
                    <td><%=rs.getString("dom_usu")%></td>
                    <td><%=rs.getString("telpart_usu")%></td>
                    <td><%=rs.getString("telcel_usu")%></td>
                    <td> <a href="editar.jsp?id=<%=rs.getInt("id_usu")%>" >Editar</a> </td>
                    <td> <a href="eliminar.jsp?id=<%=rs.getInt("id_usu")%>" >Eliminar</a> </td>
                </tr>
                
                                <%
                            }
                        //cerramos la sentencia
                        set.close();
                        //y cerramos la consulta
                        rs.close();
                            
                        }catch(SQLException ed){
                            System.out.println("Error al consultar la tabla");
                            System.out.println(ed.getMessage());
                            %>
                </tbody>
            </table>
                <h1>Error no se pueden visaulizar los datos en este momento</h1>
                            <%

                           
                        }
                    con.close();
                        
                    //error general
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
                        
            <a href="index.html">Regresar a la Página Principal</a>
        </div>
    </body>
</html>
