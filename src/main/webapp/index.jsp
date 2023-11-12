<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>
<%@ page import="com.example.web.Login" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP-Inicio de sesión</title>
</head>
<body>
<div id="cuadro">

<form action="LoginServlet" method="POST">
    <p id="titulo">INICIAR SESIÓN</p>
<hr>
<br><br>
    <label id="subtitulo1">NOMBRE DE USUARIO</label>
    <br><br>
    <input type="text" class="entrada" name="user"/>
    <br><br>
    <label id="subtitulo2">CONTRASEÑA</label>
    <br><br>
    <input type="password" class="entrada" name="key"/>
    <br><br>
    <input type="submit" value="Iniciar sesión" id="boton"/>
</form>

    <form action="LoginServlet" method="GET">
        <br>
        <button type="submit"> Registrarse </button>
    </form>

    <br>
<p id="marca">GR-4</p>
</div>
</body>
</html>