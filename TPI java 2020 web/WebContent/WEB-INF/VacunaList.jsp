<%@page import="java.util.ArrayList"%>
<%@page import="logic.VacunaLogic"%>
<%@page import="entities.Vacuna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Vacunas</title>
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
<% 
ArrayList<Vacuna> vacunas = VacunaLogic.getAll();	
%>
<title>Vacunas</title>
</head>
<body>
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('images/cachorros.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<a href="index.jsp" class="btn-flotante">↩</a>
				<form action="adopcion" method="post">
					<table class="table" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>ID</th>
								<th>Titulo</th>
								<th>Especie</th>
								<th>Descripcion</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (Vacuna v : vacunas) {
							%>
							<tr>
								<td class="mascota"><span><%=v.getId()%></span></td>
								<td><span><%=v.getTitulo()%></span></td>
								<td><%=v.getEspecie()%></td>
								<td><%=v.getDescripcion()== null ? "-" : v.getDescripcion() %></td>
							</tr>
							<%}%>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>