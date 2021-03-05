<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="entities.Mascota"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Mascota> lm = (ArrayList<Mascota>) request.getAttribute("listaMascotas");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mascotas</title>
</head>
<body>
	<table class="table" width="100%" cellspacing="0">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Tipo</th>
				<th>Edad</th>
				<th>Color</th>
				<th>Disponibilidad</th>
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
				<td><%=m.getDisponible() ? "Si" : "No"%></td>
				<td><img src="<%=m.getImagenes()%>" /></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>