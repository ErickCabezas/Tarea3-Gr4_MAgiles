<%@ page import="com.example.web.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: erick cabezas
  Date: 11/11/2023
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MATRICULA</title>
</head>
<body>
<h1><b>EMPIEZA CON TU MATRICULA</b></h1>
<form action="MatriculaServlet" method="POST">
    <%
        Usuario user = (Usuario) request.getSession().getAttribute("userMatricula");
    %>
    <p><b>Hola <%=user.getNombre()%>  <%=user.getApellido()%> </b></p>
    <p>User: <%= user.getLogin().getUsuario()%></p>
    <p><b>--------------------------------------------</b></p>
    <p><b>Seleccione el horarario al que se quiere matricular</b></p>
    <select name="horario">
        <option value="0" selected>.....</option>
        <option value="7-9">7-9</option>
        <option value="9-11">9-11</option>
        <option value="11-13">11-13</option>
        <option value="14-16">14-16</option>
        <option value="16-18">16-18</option>
        <option value="18-20">18-20</option>
    </select>
    <button type="submit"> Guardar </button>
</form>
<br>
<%
    String notificacion = ".....";
    notificacion=(String) request.getSession().getAttribute("noti");
%>
<p><%=notificacion%></p>
<br>
</body>
</html>
