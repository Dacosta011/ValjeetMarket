<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1269c35f52.js" crossorigin="anonymous"></script>
        <title>JSP Page</title>
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
                        <a class="nav-link" href="#"><i class="fas fa-home"></i> Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Productos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ControladorProveedor?menu=Proveedor&accion=Listar" target="myFrame">Proveedores</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ControladorCompra?menu=NuevaVenta&accion=default" target="myFrame">Nueva Compra</a>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${usuario.getNombreU()}
                            <input type="hidden" name="idus" value="${usuario.getIdU()}">
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">
                                <img src="img/user.png" alt="60" width="60"/>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" style="color: red " href="index.jsp">Salir</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
                        
                        
        <div class="embed-responsives m-4" style="height: 530px;">
             <iframe class="embed-responsive-item" name="myFrame"  style="height: 100%; width: 100%; border:navy"></iframe>
        </div>   
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
