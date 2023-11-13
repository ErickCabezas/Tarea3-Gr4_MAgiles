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
    <p><b>Nivel:</b></p>
    <select name="nivel">
        <option value="0" selected>.....</option>
        <option value="1">7-9</option>
        <option value="2">9-11</option>
        <option value="3">11-13</option>
        <option value="4">14-16</option>
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
