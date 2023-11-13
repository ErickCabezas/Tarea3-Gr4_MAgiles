<%--
  Created by IntelliJ IDEA.
  User: erick cabezas
  Date: 11/11/2023
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calificar</title>
</head>
<body>
<h1>Datos del Estudiante</h1>
<form action="CalificarServlet" method="POST">
    <p><label>Usuario del estudiante:</label><input type="text" name="usuario"></p>
    <p><b>Seleccione el nivel del estudiante:</b></p>
    <select name="nivel">
        <option value="0" selected>.....</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
    </select>
    <button type="submit"> Guardar </button>
</form>
<br>
<%
    String calificado = ".....";
    calificado=(String) request.getSession().getAttribute("Notificacion");
%>
<p><%=calificado%></p>
<br>
</body>
</html>
