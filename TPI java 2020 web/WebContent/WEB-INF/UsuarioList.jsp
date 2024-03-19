<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="entities.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Usuario> lt = (ArrayList<Usuario>) request.getAttribute("listaUsuarios");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
	<a href="index.jsp" class="btn-back">HOME</a>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Usuario</th>
	
		<%
			for (Usuario u : lt) {
		%>
		<tr>
			<td><%=u.getNombre()%></td>
			<td><%=u.getApellido()%></td>
			<td><%=u.getUsuario()%></td>
			<td><a href="UsuarioController?action=edit&id=<%=u.getId()%>">Editar</a> | <a href="UsuarioController?action=delete&id=<%=u.getId()%>">Eliminar</a></td>
		</tr>
		
		<%
			}
		%>
		
	</table>
	
	
<style>
body {
display: flex;
flex-direction: column;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
  
}
.imagen{
height:120px;
}

td, th {
  border: 1px solid #888888;
  text-align: left;
  padding: 8px;

}
.mascota{
display:flex;
  flex-direction: column;
  }

tr:nth-child(even) {
  background-color: #dddddd;
  
}
.btn-back, .btn-adopcion {
	display: inline-table;
	font-size: 16px; /* Cambiar el tama�o de la tipografia */
	font-weight: bold; /* Fuente en negrita o bold */
	color: #ffffff; /* Color del texto */
	border-radius: 25px; /* Borde del boton */
	letter-spacing: 2px; /* Espacio entre letras */
	background-color: #fc00ff ; /* Color de fondo */
	padding: 10px 25px; /* Relleno del boton */
	box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
	box-sizing: border-box;
	margin: 1rem;
	border: none;
}



.btn-box {
display: flex;
justify-content: center;
position: fixed;
width: 100%;
bottom: 0;
}

</style>
</body>
</html>