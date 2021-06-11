<%-- 
    Document   : index
    Created on : 10/06/2021, 06:03:05 PM
    Author     : leone
--%>
 

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    </head>
    <body>
        <!--Uso del framework bootstrap para introducir una barra de navegación con responsive design :D-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">Ben & Jerry´s</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="Controlador?accion=home">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">Oferta del día</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="Controlador?accion=Carrito"><i class="fas fa-cart-plus" >
                              (<label style="color:darkmagenta" >${contador}</label>)</i>Carrito de Compras</a>
                  </li>
                </ul>
                <form class="d-flex">
                  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-outline-success" type="submit">Buscar</button>
                </form>
                  <ul  class="navbar-nav">
                      <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Iniciar sesión
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <li><a class="dropdown-item" href="iniciarsesion.html">Iniciar sesión</a></li>
                      <li><a class="dropdown-item" href="registrousuarios.jsp">Registrar</a></li>
                    </ul>
                  </li>
                  </ul>  
              </div>
            </div>
          </nav>
        
        <div class="container mt-2" >
            <div class="row" >
                <c:forEach var="p" items="${productos}">
                    <div class="col-sm-4" >
                    <div class="card">
                        <div class="card-header" >
                            <label>${p.getNombre_producto()}</label>
                        </div>
                        <div class="card-body" >
                            <i>$.${p.getPrecio_producto()}</i>
                            <img src="ControladorIMG?=id=${p.getId_producto()}" width="200" height="180"
                        </div>
                        <div class="card-footer text-center" >
                            <label>${p.getDescripcion_producto()}</label>
                            <div>
                                <a href="Controlador?accion=AgregarCarrito&id=${p.getId()}" class="btn btn-outline-info" >Agregar al carrito</a>
                                <a href="Controlador?accion=Comprar"class="btn btn-danger" >Comprar</a>
                            </div>
                        </div>                        
                    </div>
                </div>
            </div>
                </c:forEach>
                
        </div>
        <h1>¡Bienvenido a Ben & Jerry's!</h1>
        <script src="https://kit.fontawesome.com/85383d2eda.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
        
    </body>
</html>
