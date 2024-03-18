<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="entities.Mascota"%>
<%@page import="java.util.ArrayList"%>
<%LinkedList<Mascota> lm = (LinkedList<Mascota>) request.getAttribute("listaMascotas");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mascotas</title>
</head>
<body>
	<a href="index.jsp" class="btn-back">HOME</a>
	<table class="table" width="100%" cellspacing="0">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Tipo</th>
				<th>Edad</th>
				<th>Color</th>
				<th>Imagenes</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Mascota m : lm) {
			%>
			<tr>
				<td><%=m.getId()%></td>
				<td><%=m.getNombre()%></td>
				<td><%=m.getTipo()%></td>
				<td><%=m.getEdad()%></td>
				<td><%=m.getColor()%></td>
				<td><img class="imagen" src="<%=m.getImagenes()%>" /></td>
			</tr>
			<%
			}
			%>
		</tbody>
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

tr:nth-child(even) {
  background-color: #dddddd;
}
.btn-back {
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
}
</style>
</body>
</html>