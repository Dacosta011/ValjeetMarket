
<%@page import="Negocio.Producto"%>
<%@page import="Gestion.GestionProducto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>        
        <div class="d-flex" >
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-body">
                        <form action="Controlador?menu=Producto" method="POST">
                            
                            <div class="form-group">
                                <label>ID</label>
                                <input type="text" value="${productoe.getIdPo()}" name="txtid" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Nombre Producto</label>
                                <input type="text" value="${productoe.getNombrePo()}" name="txtNombres" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Precio</label>
                                <input type="text" value="${productoe.getPrecioCompraPo()}" name="txtPre" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Foto</label>
                                <input type="file" value="" name="txtFoto" class="form-control">
                            </div>                        
                            <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                            <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        </form>
                    </div>                         
                </div>
            </div>                     
            <div class="col-sm-8" >
                <div class="card">
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Foto</th>  
                                    <th>Nombres</th>
                                    <th>Stock</th>
                                    <th>Precio Compra</th>                                    
                                    <th>Precio Venta</th>                                    
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody> 
                                <%
                                    GestionProducto gp = new Gestion.GestionProducto();
                                    ArrayList<Producto> pro = gp.getTodos();
                                    for (Producto producto : pro) 
                                    {%>
                                    
                                    <tr>
                                        <td> <%= producto.getIdPo() %> </td>
                                        <th> <img src="img/<%= producto.getNombreFotoPo() %>"/> </th>
                                        <td><%= producto.getNombrePo()%></td>
                                        <td><%= producto.getCantidadPo()%></td>
                                        <td><%= producto.getPrecioCompraPo()%></td>
                                        <td><%= producto.getPrecioVentaPo()%></td>                                        
                                        <td>
                                            <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&id=<%= producto.getIdPo()%>">Editar</a>
                                            <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Delete&id=<%= producto.getIdPo()%>">Delete</a>
                                        </td>
                                    </tr>
                                            
                                    <%}%>
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>      
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

