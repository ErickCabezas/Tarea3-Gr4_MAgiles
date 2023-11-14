<%--
  Created by IntelliJ IDEA.
  User: erick cabezas
  Date: 11/11/2023
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REGISTRO DE USUARIOS</title>
</head>
<body>
<h1>Datos de registro</h1>
<form action="RegistroServlet" method="POST">
    <p><label>Nombre:</label><input type="text" name="nombre"></p>
    <p><label>Apellido:</label><input type="text" name="apellido"></p>
    <p><label>CI:</label><input type="text" name="ci"></p>
    <p><label>Correo:</label><input type="text" name="correo"></p>
    <p><label>Telefono:</label><input type="text" name="telf"></p>
    <p><label>Usuario:</label><input type="text" name="user"></p>
    <p><label>Contraseña:</label><input type="text" name="key"></p>
    <p><b>Tipo de usuario:</b>
    <input type="radio" name="tipoUser" value="estudiante"/>Estudiante
        <input type="radio" name="tipoUser" value="profesor"/>Profesor</p><br>
    <button type="submit"> Registrarse </button>
</form>
<br>
<%
    String agregado = ".....";
    agregado=(String) request.getSession().getAttribute("registro");
%>
<p><%=agregado%></p>
<br>
<h1>Ver lista de usuarios</h1>
<form action="RegistroServlet" method="GET">
    <button type="submit"> Mostrar usuarios </button>
</form>
</body>
</html>
