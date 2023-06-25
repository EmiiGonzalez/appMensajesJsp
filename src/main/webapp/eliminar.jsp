<%-- 
    Document   : eliminar
    Created on : 18 jun 2023, 22:16:57
    Author     : Emii
--%>

<%@page import="java.util.*"%>
<%@page import="com.app.mensajes.Mensaje"%>
<%@page import="com.app.mensajes.MensajeDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Eliminar</title>
</head>
<body>
    <%
    String id = request.getParameter("id");
    Mensaje msg = new Mensaje(Integer.valueOf(id));
    MensajeDao mensajedao = new MensajeDao();
    mensajedao.eliminar(msg);

    request.getRequestDispatcher("index.jsp").forward(request, response);
    %>
</body>
</html>