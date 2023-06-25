<%-- 
    Document   : editar
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
    <title>Editar</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Crear mensaje</h5>
            </div>
            <div class="modal-body">
                <form action="editar.jsp" method="post">
                    <div class="mb-3">
                        <input type="hidden" name="id" value="<%=request.getParameter("id")%>">

                        <label class="form-label" for="mensaje">Editar Mensaje</label>
                        <textarea class="form-control" name="mensaje" rows="3"><%=request.getParameter("mensaje")%></textarea>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="autor">Autor</label>
                        <input type="text" class="form-control" name="autor" value="<%=request.getParameter("autor")%>">

                    </div>
                
            </div>
            <div class="modal-footer">
                <a href="index.jsp" class="btn btn-danger">Regresar</a>
                <button type="submit" class="btn btn-primary" name="enviar">Guardar Cambios</button>
                
            </div>
        </form>
        </div>

            <%
                String id = request.getParameter("id");
                MensajeDao mensajedao = new MensajeDao();

                if(request.getParameter("enviar")!=null) {
                    Mensaje msg = new Mensaje(
                        request.getParameter("mensaje").trim(),
                        Integer.parseInt(id.trim()),
                        request.getParameter("autor").trim());
                    mensajedao.editar(msg);
                }


            %>
</body>
</html>