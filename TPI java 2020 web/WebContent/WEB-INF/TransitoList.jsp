<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="entities.Transito"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Transito> lt = (ArrayList<Transito>) request.getAttribute("listaTransitos");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transitos</title>
</head>
<body>
	<a href="index.jsp" class="btn-back">HOME</a>
	<form action="adopcion" method="post">
	<table class="table" width="100%" cellspacing="0">
		<thead>
			<tr>
				<th>Mascota</th>
				<th>fecha_hora_donacion</th>
				<th>Donante</th>
				<th>En adopción?</th>
				<th>Adoptado Por:</th>
				<th>fecha_hora_adopcion</th>
				<th>Elegir</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Transito t : lt) {
			%>
			<tr>
				<td class="mascota"><span><%=t.getMascota().getNombre()%></span><img class="imagen" src="<%=t.getMascota().getImagenes()%>" /></td>
				<td><%=t.getFechaHoraDonacion()%></td>
				<td><%=t.getDonante().getNombre()%></td>
				<td><%=t.getAdoptante() == null ? "Si" : "No" %></td>
				<td><%=t.getAdoptante() == null ? "---" : t.getAdoptante().getNombre()%></td>
				<td><%=t.getFechaHoraAdopcion() == null ? "---" : t.getFechaHoraAdopcion()%></td>
				<td>
				<%if(t.getAdoptante() == null) {%>
					<input type="radio"  name="seleccionada" value="<%=t.getId()%>">
				<%}%>
				</td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<div class="btn-box"><button type="submit" class="btn-adopcion">Adoptar</button></div>
	</form>
	
	
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
	font-size: 16px; /* Cambiar el tamaï¿½o de la tipografia */
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