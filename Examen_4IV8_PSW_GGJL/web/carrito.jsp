<%-- 
    Document   : carrito
    Created on : 7/06/2021, 10:52:25 AM
    Author     : rash2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    </head>
    <body>
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
                      <a class="nav-link" href="Controlador?accion=home">Seguir Comprando</a>
                  </li>
                </ul>
                <form class="d-flex">
                  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
                  <ul  class="navbar-nav">
                      <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Iniciar sesión
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <li><a class="dropdown-item" href="#">Action</a></li>
                      <li><a class="dropdown-item" href="#">Another action</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                  </li>
                  </ul>  
              </div>
            </div>
          </nav>
              
                 <div class="container mt-4" >
                     <h3>Consulta del Carrito de Compras</h3>
                     <div class="row" >
                         <div class="col-sm-8" >
                             <table class="table table-hover" >
                                 <thead>
                                     <tr>
                                         <th>ITEM</th>
                                         <th>NOMBRE</th>
                                         <th>DESCRIPCIÓN</th>
                                         <th>PRECIO</th>
                                         <th>CANT</th>
                                         <th>SUBTOTAL</th>
                                         <th>ACCIÓN</th>
                                     </tr>
                                 </thead>
                                 <tbody>
                                     <c:forEach var="car" items="${carrito}" >
                                         <tr>
                                         <td>${car.getItem()}</td>
                                         <td>${car.getNombres()}</td>
                                         <td>
                                             <!--etiqueta para la imagen del helado-->
                                             <img src="ControladorIMG?id=${car.getIdProducto()}" width="100" height="100" >
                                             <br>${car.getDescripcion()}
                                         </td>
                                         <td>${car.getPreciocompra}</td>
                                         <td>
                                             <input type="hidden" id="idpro" value="${car.getIdProducto()}" >
                                             <input type="number" id="cantidad" value="${car.getCantidad()}" class="form-control text-center"
                                                    min="1">
                                         </td>
                                         <td>${car.getSubtotal}</td>
                                         <td>
                                             <a href="#" >Eliminar</a>
                                             <a href="#" >Editar</a>
                                         </td>
                                     </tr>
                                     </c:forEach>
                                 </tbody>
                             </table>
                             
                         </div>
                         <div class="col-sm-4" >
                             <div class="card" >
                                 <div class="card-header" >
                                     <h3>Generar Compra</h3>
                                 </div>
                                 <div class="card-body" >
                                     <label>Subtotal:</label>
                                     <input type="text" value="$.${totalPagar}0" readonly="readonly"  class="form-control" >
                                     <label>Descuento:</label>
                                     <input type="text"  value="$0.00" readonly="readonly"  class="form-control" >
                                     <label>Total a Pagar:</label>
                                     <input type="text" value="$.${totalPagar}0" readonly="readonly"  class="form-control" >
                                 </div>
                                 <div class="card-footer" >
                                     <a href="#" class="btn btn-outline-info btn-block" >Realizar Pago</a>
                                     <a href="#" class="btn btn-outline-info btn-block">Generar Compra</a>
                                 </div>
                             </div>
                         </div>
                         
                     </div>
                     
                 </div>
          <script src="https://kit.fontawesome.com/85383d2eda.js" crossorigin="anonymous"></script>
          <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
    </body>
</html>
