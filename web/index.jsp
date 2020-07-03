
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    </head>
    <body class="container">
        
        <nav class="mt-3 nav justify-content-end">
            <a class="nav-link border rounded" href="registro.jsp">Registrarse</a>
        </nav>  
        
        <div class="mx-auto" style="width: 300px;">
            <h2 style="text-align: center" >Iniciar Sesión</h2>
        </div>
        
        <form class="mt-5 justify-content-center border rounded" id="formInicio">
            <div class="col-auto p-2">
                <div class="col-5 " style="margin: auto;">
                    <label class="" for="inlineFormInput">Usuario</label>
                    <input type="text" class="form-control mb-2" id="usuario" placeholder="Jane">
                </div>
                <div class="col-5" style="margin: auto;">
                    <label class="" for="inlineFormInputGroup">Correo</label>
                    <input type="text" class="form-control mb-2" id="correo" placeholder="correo@example.com">
                </div>
                <div class="col-5" style="margin: auto;">
                    <label class="" for="inlineFormInputGroup">Contraseña</label>
                    <input type="password" class="form-control" id="pass" placeholder="Password">
                </div>

                <div class="col-5 mt-3 " style="margin: auto;" >
                    <button type="submit" class="btn btn-primary mb-2">Iniciar Sesión</button>
                </div>
            </div>
        </form>
        
        <script
            src="https://code.jquery.com/jquery-3.3.1.min.js" 
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous">
        </script>
        <script src="js/app.js"></script>
    </body>
</html>
