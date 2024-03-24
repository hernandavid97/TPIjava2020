<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="entities.Mascota"%>
<%@page import="entities.Vacunacion"%>
<%@page import="java.util.ArrayList"%>
<%
LinkedList<Mascota> lm = (LinkedList<Mascota>) request.getAttribute("listaMascotas");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->

<title>Mascotas</title>
</head>
<body>
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('images/cachorros.jpg');">
			<div
				class="max-w-wrapper wrap-login100 login100-form p-l-55 p-r-55 p-t-54 p-b-54">
				<a href="index.jsp" class="btn-flotante">↩</a>
				<table class="table" width="70%" cellspacing="0">
					<thead>
						<tr>
							<th>Mascota</th>
							<th>Especie</th>
							<th>Edad</th>
							<th>Color</th>
							<th>Vacunas</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (Mascota m : lm) {
						%>
						<tr>
							<td><div><%=m.getNombre()%></div> <img class="imagen"
								src="<%=m.getImagenes()%>" /></td>
							<td><%=m.getTipo()%></td>
							<td><%=m.getEdad()%></td>
							<td><%=m.getColor()%></td>
							<%
							LinkedList<Vacunacion> vacunaciones = m.getVacunaciones();
							if (!vacunaciones.isEmpty()) {
							%>
							<td>
								<ul>
									<%
									for (Vacunacion v : vacunaciones) {
									%>
									<li>
										<p><%=v.getVacuna().getTitulo()%></p>
										<p>
											Fecha
											<%=v.getFecha_vacunacion()%>
										</p>
									</li>
									<%
									}
									%>
								</ul>
							</td>
							<%
							} else {
							%>
							<td><p>No tiene</p></td>
							<%
							}
							%>
						</tr>
						<%
						}
						%>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<style>
.table thead th {
	width: 20%,
}

.max-w-wrapper {
	max-width: 1200px;
	margin: auto;
}

.imagen {
	max-height: 400px;
	max-width: 400px;
}

td {
	width: 1px;
}
</style>
</body>
</html>