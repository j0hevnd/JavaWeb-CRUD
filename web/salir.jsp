<%-- 
    Document   : salir
    Created on : 19/06/2020, 09:36:36 AM
    Author     : jhone
--%>

<%@page import="javax.jms.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession objSesion = request.getSession(true);
            objSesion.invalidate();
            response.sendRedirect("index.jsp");
        %>
    </body>
</html>
