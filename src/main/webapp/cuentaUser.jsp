<%@ page import="com.example.web.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: erick cabezas
  Date: 11/11/2023
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cuenta Cambrige</title>
</head>
<body>
<h1><b>BIENBENIDO A CAMBRIGE</b></h1>
<%
    Usuario usuario = (Usuario) request.getSession().getAttribute("loginUser");
%>
<p><b> Modo :</b><%=usuario.getModoUsuario()%></p>
<br>
<p><b>Usuario :</b><%=usuario.getLogin().getUsuario()%></p>
<br>
<p><b>Nombre completo:</b><%=usuario.getNombre()%> <%=usuario.getApellido()%></p>
<br>
<p><b> ci :</b><%=usuario.getCi()%></p>
<br>
<p><b> correo :</b><%=usuario.getCorreo()%></p>
<br>
<p><b> telefono :</b><%=usuario.getTelefono()%></p>
<br>
<p><b> Nivel :</b><%=usuario.getInscripcion().nivel%></p>
<%
    if(usuario.getModoUsuario().equals("profesor")){
%>
<br>
<form action="CuentaServlet" method="GET">
    <button type="submit" name="opc" value="calificar"> calificar </button>
</form>
<%}else{%>
<br>
<form action="CuentaServlet" method="POST">
    <button type="submit"> Inscribirse en curso </button>
</form>
<%}%>
<br>
<form action="CuentaServlet" method="GET">
    <button type="submit" name="opc" value="cerrar"> cerrar sesión </button>
</form>
</body>
</html>
