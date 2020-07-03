$(document).ready(function () {

    let edit = false;

    fetchUsers(); // Iniciamos la funcion que nos muestra lo que tenemos en la base de datos 

    //ADD OR EDIT 
    $('#formRegistro').submit(e => {
        e.preventDefault();
        const postData = {
            id: $('#Input_id').val(), //Resivimos el valor de lo que tenemos en los inputs 
            usuario: $('#usuario').val(),
            nombre: $('#nombre').val(),
            apellido: $('#apellido').val(),
            correo: $('#correo').val(),
            pass: $('#pass').val()
        };
        //console.log(postData);
        const url = edit === false ? "AddUser" : "UpdateUser"; //EDITA O GUARDA DEPENDIENDO DE LA VARIABLE EDIT
        //console.log(url);
        $.post(url, postData, (response) => { // Enviamos los datos por el metodo post al servet que corresponda en la url. // usamos ajax
            // console.log(response);
            if(response !== "true"){
                alert("Debe llenar todos los campos");
            }else if(edit === false) {
                alert("Datos guardados correctamente");
                $('#formRegistro').trigger('reset'); // Reseteamos el formulario
            }else if(edit === true) {
                alert("Datos actualizados correctamente");
                $('#formRegistro').trigger('reset'); 
                edit = false;
                $('#usuario').removeAttr('disabled');
                $('#correo').removeAttr('disabled');
                $('#pass').removeAttr('disabled');
            }
            fetchUsers(); // Mostramos de nuevo ya actualizado la consulta de los datos que tenemos
            if(edit === false) {
                $('#btn-submit').html("Registrarse");
            }
        });
    });

    //LIST BY ID 
    function fetchUsers() { // Funcion que contiene las vistas de lo que tengamos en la base de datos
        $.ajax({ // usamos ajax
            url: "ListUser", // Sitio donde haremos la consulta
            type: 'GET', // tipo de dato que se espera
            success: function (response) { // Cuando haya finalizado la peticion vendra aquí y nos traera la respuesta que retorne ListUser
                const users = JSON.parse(response); // Convertimos la respuesta en un json y la guardamos en users
                // console.log(response);
                let template = ''; // Creamos un template vacio que sera lo que se añade al html en casi de que la respuesta del servidor sea negativa
                users.forEach(user => { // Recorremos el resultado de la respuesta // Añadimos cada cosa que encuentre en template
                    template += ` 
                  <tr userId="${user.id_usuario}">
                    <td>${user.id_usuario}</td>

                    <td>
                        <a href="#" class="user-item">
                          ${user.usuario} 
                        </a>
                    </td>
                    <td>${user.nombre}</td>
                    
                    <td>${user.correo}</td>

                    <td>
                      <button class="user-delete btn btn-danger">
                       Borrar
                      </button>
                    </td>
                  </tr>
                `
                });
                $('#list-users').html(template); // Añadimos el template al cuerpo de la tabla
            }
        });
    }
    
    // DELETE USER BY ID
    $(document).on('click', '.user-delete', (e) => {
        if (confirm('Este Usuario sera eliminado')) {
            const element = $(this)[0].activeElement.parentElement.parentElement; // Obtenemos la etiqueta de donde hayamos hecho click 
            const id = $(element).attr('userId'); // obtenemos el atributo de la etiqueta
            $.post('DeleteUser', {id}, (response) => { 
                fetchUsers(); // Mostramos de nuevo ya actualizado la consulta de los datos que tenemos
            });
        }
    });


    // GET AND LIST USER BY ID
    $(document).on('click', '.user-item', (e) => {
        const element = $(this)[0].activeElement.parentElement.parentElement; // Obtenemos la etiqueta de donde hayamos hecho click 
        const id = $(element).attr('userId');
        $.post('EditUser', {id}, (response) => { // Usamos ajax para enviar a al servlet EditaUser el id del dato que deseamos eliminar
            const user = JSON.parse(response); // Convertimos la respuesta en un json
            //console.log(user[0]);
            $('#usuario').val(user[0].usuario).prop('disabled', true); // Mostramos los datos que tenemos en la base de datos y cambimaos su valor si queremos
            $('#nombre').val(user[0].nombre);
            $('#apellido').val(user[0].apellido);
            $('#Input_id').val(user[0].id_usuario);
            $('#correo').prop('disabled', true);
            $('#pass').prop('disabled', true);
            $('#btn-submit').html('Actualizar');
            edit = true;
        });
        e.preventDefault();
    });

    // LOGIN
    $('#formInicio').submit(e => {
        e.preventDefault();
        const postData = {
            usuario: $('#usuario').val(),
            correo: $('#correo').val(),
            pass: $('#pass').val()
        };
        // console.log(postData);
        $.post("InicioSesion", postData, (response) => { // Enviamos los datos por el metodo post al servet que corresponda en la url. // usamos ajax
            const respuesta = JSON.parse(response);
            if(respuesta[0] === "true"){
                window.location = "menu.jsp";
            }else if(respuesta[1] === ""){
                alert("Datos incorrectos");
                $('#formInicio').trigger('reset'); // Reseteamos el formulario  
            }else {
                alert(respuesta[1]);
            }
        });
    });
    
});

