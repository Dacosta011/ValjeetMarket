<%-- 
    Document   : carrito
    Created on : 9/12/2019, 11:45:36 AM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1269c35f52.js" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Valjeet Market</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="Controlador1?accion=llenar">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Ofertas del Dia</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador1?accion=llenar">Seguir Comprando</a>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${usuario.getNombreU()}
                            <input type="hidden" name="idus" value="${usuario.getIdU()}">
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" style="color: red" href="Controlador1?accion=Salir">Salir</a>
                        </div>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>

        <div class="container mt-4">
            <div class="row">
                <div class="col-sm-8">
                    <div class="d-flex ml-auto col-sm-6">
                        <label class="text-right mt-2 col-sm-6">NRO. SERIE</label>
                        <input readonly="" type="text" name="numeroserie" class="form-control text-center" value="${nserie}" style="font-weight: bold;font-size: 18px">
                    </div>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Item</th>
                                <th>Nombres</th>
                                <th>Foto</th>
                                <th>Precio</th>
                                <th>Cantidad</th>
                                <th>Subtotal</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="car" items="${carrito}">
                                <tr>
                                    <td>${car.getItem()}</td>
                                    <td>${car.getNombres()}</td>
                                    <td><img src="img/${car.getNombreFoto()}" width="100" height="100"></td>
                                    <td>${car.getPrecioCompra()}</td>
                                    <td>${car.getCantidad()}</td>
                                    <td>${car.getSubtotal()}</td>
                                    <td>
                                        <input type="hidden" id="idp" value="${car.getIdProducto()}">
                                        <a href="" id="btnElimina" class="btn btn-danger btn-block">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
                <div class="col-sm-4">
                    <form action="Controlador1">
                        <div class="card">
                            <div class="card-header">
                                <h3>Generar Compra</h3>
                            </div>
                            <div class="card-body">
                                <label>Subtotal</label>
                                <input type="text" readonly="" value="$.${total}" class="form-control">
                                <label>Descuento</label>
                                <input type="text" readonly="" value="$.0.00" class="form-control">
                                <label>Total</label>
                                <input type="text" readonly="" value="$.${total}" class="form-control">
                            </div>
                            <div class="card-footer">
                                <div class="d-flex">
                                    <label>Credito</label>
                                    <input type="checkbox" name="checre"class="form-control">
                                </div><br>
                                <input type="submit" name="accion" value="Compra" class="btn btn-danger btn-block">

                            </div>
                        </div>
                    </form>
                </div>
            </div>
                                <c:if test="${ok == true}">
                                    <script>
                                        //alert("${mens}");
                                       swal("Compra fallida", "${mens}", "error");
                                    </script>
                                </c:if>

        </div>




        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="js/js.js" type="text/javascript"></script>
    </body>

</html>
