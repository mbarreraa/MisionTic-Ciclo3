/*
    Esta función recibe como parametro el id del registro a eliminar,
    ejecuta la petición asincrona al servidor de Oracle enviando dentro de los datos 
    de la petición registro a eliminar. El tipo de petición es DELETE
*/
function borrarRegistro(llaveRegistro) {
    // Crear objeto javaScript
    let datos = {
        id: llaveRegistro
    }

    // Convierte el objeto javaScript a formato JSON antes de agregarlo a los datos de la peticion
    let datosPeticion = JSON.stringify(datos)

    $.ajax({
        // la URL para la petición (url: "url al recurso o endpoint")
        url: "https://g07d02e4c9c4e91-dbmbarreraa.adb.us-sanjose-1.oraclecloudapps.com/ords/admin/boat/boat",
            
        // la información a enviar
        // (también es posible utilizar una cadena de datos)
        //si el metodo del servicio recibe datos, es necesario definir el parametro adicional
        data: datosPeticion,

        // especifica el tipo de petición http: POST, GET, PUT, DELETE
        type: 'DELETE',

        contentType: "application/JSON",

        // el tipo de información que se espera de respuesta
        //dataType: 'json',

        success: function(respuesta){
            //escribe en la consola del desarrollador para efectos de depuración
            console.log(respuesta);
            $("#mensajes").show(1000);
            $("#mensajes").html("Registro eliminado...");
            $("#mensajes").hide(1000);
            listar(); 
        },

        error: function(xhr, status){
            $("#mensajes").html("Ocurrio un problema al ejecutar la petición..." + status);
            $("#mensajes").hide(1000); 
        }
    });

}