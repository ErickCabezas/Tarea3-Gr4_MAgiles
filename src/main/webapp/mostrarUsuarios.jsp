<%@ page import="java.util.List" %>
<%@ page import="com.example.web.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: erick cabezas
  Date: 11/11/2023
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuarios</title>
</head>
<body>
    <h1>Lista de usuarios registrados</h1>
    <%
        List<Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
        int cont=1;
        for(Usuario user: listaUsuarios){
    %>
    <p><b>Usuario N° <%=cont%></b></p>
    <p>Info: <%= user.getLogin().getUsuario()%></p>
    <p><b>--------------------------------------------</b></p>
    <%cont+=1;%>
    <%}%>
</body>
</html>
