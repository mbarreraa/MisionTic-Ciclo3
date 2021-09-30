//Esta función ejecuta la petición asincrona al servidor de Oracle, envia una
//petición al ws de tipo POST
function registrar() {
    // Crear objeto javaScript
    let datos = {
        id: $("#id").val(),
        name: $("#name").val(),
        brand: $("#brand").val(),
        model: $("#model").val(),
        category_id: $("#category").val() 
    }

    // Convierte el objeto javaScript a formato JSON antes de agregarlo a los datos de la peticion
    let datosPeticion = JSON.stringify(datos)

    // Valida los datos
    if (validar()){

        $.ajax({
            // la URL para la petición (url: "url al recurso o endpoint")
            url: "https://g07d02e4c9c4e91-dbmbarreraa.adb.us-sanjose-1.oraclecloudapps.com/ords/admin/boat/boat",
                
            // la información a enviar
            // (también es posible utilizar una cadena de datos)
            //si el metodo del servicio recibe datos, es necesario definir el parametro adicional
            data: datosPeticion,

            // especifica el tipo de petición http: POST, GET, PUT, DELETE
            type: 'POST',

            contentType: "application/JSON",

            // el tipo de información que se espera de respuesta
            //dataType: 'json',

            success: function (respuesta) {
                //escribe en la consola del desarrollador para efectos de depuración
                console.log(respuesta);
                $("#mensajes").show(1000);
                $("#mensajes").html("Registro ingresado...");
                $("#mensajes").hide(1000);
                listar();
                estadoInicial();
            }, 

            // código a ejecutar si la petición falla;
            // son pasados como argumentos a la función
            // el objeto de la petición en crudo y código de estatus de la petición
            error: function (xhr, status) {
                $("#mensajes").show(1000);
                $("#mensajes").html("Error peticion POST..." + status );
                //$("#mensajes").hide(1000);
            } 
        });
    }

}

/**
 * Configura el aspecto de la página para ingresar un nuevo registro
 */
function activaNuevo(){
    $("#nuevo").show(500);
    $("#id").focus();
    $("#editar").hide();
    $("#nuevoRegistro").hide(500)
    $("#listado").hide(500); 
}