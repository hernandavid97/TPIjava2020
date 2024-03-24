<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="entities.Transito"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<Transito> lt = (ArrayList<Transito>) request.getAttribute("listaTransitos");
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
<title>Transitos</title>
</head>
<body>
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('images/cachorros.jpg');">
			<div class="wrap-login100 login100-form p-l-55 p-r-55 p-t-54 p-b-54">

				<a href="index.jsp" class="btn-flotante">↩</a>
				<form action="adopcion" method="post">
					<table class="table" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>Mascota</th>
								<th>Especie</th>
								<th>Fecha publicación</th>
								<th>Donante</th>
								<th>En adopción?</th>
								<th>Adoptado por</th>
								<th>Fecha Adopción</th>
								<th>Elegir</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (Transito t : lt) {
							%>
							<tr>
								<td class="mascota"><span><%=t.getMascota().getNombre()%></span><img
									class="imagen" src="<%=t.getMascota().getImagenes()%>" /></td>
								<td><%=t.getMascota().getTipo()%></td>
								<td><%=t.getFechaHoraDonacion()%></td>
								<td><%=t.getDonante().getNombre()%></td>
								<td><%=t.getAdoptante() == null ? "Si" : "No"%></td>
								<td><%=t.getAdoptante() == null ? "---" : t.getAdoptante().getNombre()%></td>
								<td><%=t.getFechaHoraAdopcion() == null ? "---" : t.getFechaHoraAdopcion()%></td>
								<td>
									<%
									if (t.getAdoptante() == null) {
									%> <input type="radio" name="seleccionada"
									value="<%=t.getId()%>"> <%
 }
 %>
								</td>
							</tr>
							<%
							}
							%>

						</tbody>
					</table>
					<div class="container-login100-form-btn m-t-25 btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">Adoptar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<style>
.btn {
	width: fit-content;
	margin: 0 auto;
}

.imagen {
	height: 120px;
}
</style>
</body>
</html>
