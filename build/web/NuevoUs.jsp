<%-- 
    Document   : NuevoUs
    Created on : 11/12/2019, 10:57:33 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <img src="img/slide.jpg"/>
    </center> 
    <div class="container mt-4 col-lg-4"> 
        <div class="card col-sm-10">
            <div class="card-body">
                <form class="form-sign" action="Controlador1" method="POST">
                    <div class="form-group text-center">
                        <h3>Registro</h3>

                        <label>Bienvenidos a Valjeet Market</label>
                    </div>
                    <div class="form-group ">
                        <label>ID:</label>
                        <input type="text" name="txtid"  class="form-control">
                    </div>
                    <div class="form-group">
                        <label>NOMBRES:</label>
                        <input type="text" name="txtnom"  class="form-control">
                    </div>
                    <div class="form-group">
                        <label>TIPO DE USUARIO:</label>
                        <select class="form-control" name="tipous">
                            <option disabled="" selected="">--Opciones--</option>
                            <option>Persona</option>
                            <option>Empresa</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Password:</label>
                        <input type="password" name="txtpass1"  class="form-control">
                    </div>
                    <input type="submit" name="accion" value="Registrar" class="btn btn-primary btn-block">
                </form>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
