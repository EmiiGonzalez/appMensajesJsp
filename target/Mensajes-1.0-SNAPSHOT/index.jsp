<%-- 
    Document   : index
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
        <title>Document</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    </head>
    <body>
        <!-- Modal -->
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Crear mensaje</h5>
                </div>
                <div class="modal-body">
                    <form action="index.jsp" method="post">
                        <div class="mb-3">
                            <label class="form-label" for="mensaje">Ingrese el Mensaje</label>
                            <textarea class="form-control" name="mensaje" rows="3"></textarea>
                            
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="autor" >Autor</label>
                            <input type="text" class="form-control" name="autor" >
                        </div>
                    
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" name="enviar">Enviar</button>
                </div>
            </form>
            </div>

            <%
                MensajeDao mensajedao = new MensajeDao();

                if(request.getParameter("enviar")!=null) {
                    Mensaje msg = new Mensaje(
                        request.getParameter("mensaje").trim(), 
                        request.getParameter("autor").trim());
                    mensajedao.insertar(msg);
                }
            %>

            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Todos los mensajes</h5>
                </div>
                <%
                    //MensajeDao mensajedao = new MensajeDao();
                    List<Mensaje> mensajes = mensajedao.seleccionar();
                    Collections.reverse(mensajes);
                
                    for (Mensaje mensaje : mensajes) {
                    %>
                        <div class="modal-body">
                            <div class="card" >
                                <div class="card-body">
                                <h5 class="card-title"><%=mensaje.getAutor()%></h5>
                                <p class="card-text"> <%=mensaje.getMensaje()%> </p>
                                <p class="blockquote-footer"><cite> <%=mensaje.getFecha()%></cite></p>
                                <a href="editar.jsp?id=<%=mensaje.getId()%>&&mensaje=<%=mensaje.getMensaje()%>&&autor=<%=mensaje.getAutor()%>"
                                    class="card-link">Editar</a>
                                <a href="eliminar.jsp?id=<%=mensaje.getId()%>" class="card-link">Eliminar</a>
                                </div>
                            </div>
                        </div>
                    <%
                    }
                %>
            </div>
        </div>
        
    </body>
</html>