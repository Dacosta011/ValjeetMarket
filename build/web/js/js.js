/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("tr #btnElimina").click(function () {
        var idp = $(this).parent().find("#idp").val();
        

   // swal("Good job!", "You clicked the button!", "success");

    eliminar(idp);    

    });
    function eliminar(idp)
    {
        var url = "Controlador1?accion=Eliminar2";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp,
            success: function (data, textStatus, jqXHR)
            {

            }

        });
       
    }
});












/*swal({
 title: "Are you sure?",
 text: "Once deleted, you will not be able to recover this imaginary file!",
 icon: "warning",
 buttons: true,
 dangerMode: true,
 })
 .then((willDelete) => {
 if (willDelete) {
 swal("Poof! Your imaginary file has been deleted!", {
 icon: "success",
 });
 } else {
 swal("Your imaginary file is safe!");
 }
 });*/