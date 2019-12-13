/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function ()
{
    $("tr #Cantidad").click(function (){
        
        var idp = $(this).parent().find("#idpro").val();
        var Can = $(this).parent().find("#Cantidad").val();
        var url = "Controlador1?accion=ActualizaCantidad";
        
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp + "&Cantidad=" + Can,
            success: function (data, textStatus, jqXHR)
            {
                location.href="Controlador1?accion=Carrito";
            }  
        });
        
    });
});
