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
<form action="RegistroServlet" method="POST">
    <p><label>Usuario del estudiante:</label><input type="text" name="usuario"></p>
    <p><label>Nivel:</label><input type="text" name="nivel"></p>
    <button type="submit"> Guardar </button>
</form>
<br>
<%
    String calificado = ".....";
    calificado=(String) request.getSession().getAttribute("Error");
%>
<p><%=calificado%></p>
<br>
</body>
</html>
