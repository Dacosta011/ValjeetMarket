<%-- 
    Document   : indexVenta
    Created on : 6/12/2019, 04:03:35 PM
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
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Valjeet Market <i class="fas fa-store"></i></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="Controlador1?accion=llenar"><i class="fas fa-home"></i> Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"><i class="fas fa-tag"></i> Ofertas del Dia</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador1?accion=Carrito"><i class="fas fa-cart-plus">(<label style="color: greenyellow">${contador}</label>)</i> Carrito</a>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${usuario.getNombreU()}
                            <input type="hidden" name="idus" value="${usuario.getIdU()}">
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="Controlador1?accion=Factura">Ver Mis Facturas <i class="fas fa-receipt"></i></a>
                            <a class="dropdown-item" href="Controlador1?accion=Pagos">Pago de Facturas <i class="fas fa-cash-register"></i></a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item text-center" style="color: red " href="Controlador1?accion=Salir">Salir</a>
                        </div>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" action="Controlador1" method="POST">
                    <input class="form-control mr-sm-2" name="buscarp" type="search" placeholder="Search" aria-label="Search">
                    <input type="submit" class="btn btn-outline-success my-2 my-sm-0" name="accion" value="Buscar">
                </form>
            </div>
        </nav>
        <div class="container mt-2">
            <div class="row">
                <c:forEach var="p" items="${productos}">
                    <c:if test="${ p.getCantidadPo() != 0 }">
                        <div class="col-sm-4">
                            <div class="card">
                                <div class="card-header">
                                    <label>${p.getNombrePo()}</label>
                                </div>
                                <div class="card-body">
                                    <i>$.${p.getPrecioVentaPo()}</i>
                                    <img src="img/${p.getNombreFotoPo()}" width="200" height="180">
                                </div>
                                <div class="card-footer text-center">
                                    <label>Opciones</label>
                                    <div>
                                        <a href="Controlador1?accion=AgregarCarrito&id=${p.getIdPo()}" class="btn btn-outline-info">Agregar a Carrito</a>
                                        <a href="Controlador1?accion=Comprar&id=${p.getIdPo()}" class="btn btn-danger">Comprar</a>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </c:if>
                </c:forEach>
            </div>

        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </body>
</html>
