<%-- 
    Document   : menu
    Created on : 7/06/2020, 08:03:36 PM
    Author     : jhone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    </head>
    <body class="container">
        
        <%
        HttpSession objSesion = request.getSession(true);
        String Usuario = objSesion.getAttribute("usuario").toString();

        if(objSesion.getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
        } else {
         
        %>
        
         <nav class="mt-3 nav justify-content-end">
            <a class="nav-link border rounded" href="salir.jsp" id="salir">Salir</a>
        </nav>  
        <div class="card" style="width: 18rem;">
          <img src="..." class="card-img-top" alt="  Aquí debería haber una imagen">
          <div class="card-body">
            <h5 class="card-title"><%  %></h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="#" class="btn btn-primary stretched-link">Go somewhere</a>
          </div>
        </div>
        
        <% } %>
    </body>
</html>
