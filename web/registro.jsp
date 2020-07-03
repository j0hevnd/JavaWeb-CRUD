<%-- 
    Document   : registro
    Created on : 3/06/2020, 03:16:51 PM
    Author     : jhone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    </head>
    <body class="container" >
        
        <nav class="mt-3 nav justify-content-end">
            <a class="nav-link border rounded" href="index.jsp">Volver</a>
        </nav>  
        
        <div class="mx-auto" style="width: 300px;">
            <h2 style="text-align: center" >Registro</h2>
        </div>
        
        <form class="mt-5 p-2" id="formRegistro" >
            <div class="col justify-content-center">
                <div class="col-5" style="margin: auto;">
                    <input type="hidden" id="Input_id"> <!-- Este input sera le que nos guardara el Id de lo que seleccionemos  -->
                    <input type="text" id="usuario" class="form-control mb-2" placeholder="Nombre de Usuario">
                </div>
                <div class="col-5" style="margin: auto;">
                    <input type="text" id="nombre" class="form-control mb-2" placeholder="Nombre">
                </div>
                <div class="col-5" style="margin: auto;">
                    <input type="text" id="apellido" class="form-control mb-2" placeholder="Apellido">
                </div>
                <div class="col-5" style="margin: auto;">
                    <input type="text" id="correo" class="form-control mb-2" placeholder="Correo">
                </div>
                <div class="col-5" style="margin: auto;">
                    <input type="password" id="pass" class="form-control mb-3" placeholder="Contraseña">
                </div>
                <div class="col-5 mx-auto" style="width: 200px;">
                    <button type="submit" class="btn btn-primary btn-block" id="btn-submit">Registrarse</button>  
                </div>
            </div>
        </form>
        
        <table class="table table-striped" style="margin: 50px auto 70px auto;">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Usuario</th>
                    <th scope="col">Nombres</th>
                    <th scope="col">Correo</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody id="list-users"></tbody>
        </table>
       
        <script
            src="https://code.jquery.com/jquery-3.3.1.min.js" 
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous">
        </script>
        <script src="js/app.js"></script>
    </body>
</html>
