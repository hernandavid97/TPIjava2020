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
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>	<div class="limiter">
	<div class="container-login100" style="background-image: url('images/cachorros.jpg');">
		<div class="wrap-login100 login100-form p-l-55 p-r-55 p-t-54 p-b-54">

			<a href="index.jsp" class="btn-flotante">↩</a>
				<table class="table" width="100%" cellspacing="0" >
					<thead>
						<tr>
						<th>Id</th>
						<th>Usuario</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Domicilio</th>
						<th>Email</th>
						<th>Tipo D.</th>
						<th>Documento</th>
						<th>Localidad </th>
						<th>Admin</th>
					</tr>
					</thead>
					<tbody>
					<%
						for (Usuario u : lt) {
							if (u.getFechaBaja() == null) {
					%>
					<tr>
						<td><%=u.getId()%></td>
						<td><%=u.getUsuario()%></td>
						<td><%=u.getNombre()%></td>
						<td><%=u.getApellido()%></td>
						<td><%=u.getDomicilio()%></td>
						<td><%=u.getEmail()%></td>
						<td><%=u.getTipoDoc()%></td>
						<td><%=u.getNroDoc()%></td>
						<td><%=u.getLocalidad().getNombre()%></td>
						<td><%=u.getTipo() == 0 ? "Si":"No"%></td>
					</tr>
						<%}%>
						<%}%>
					</tbody>
				</table>	
		</div>
	</div>
</div>
</body>
</html>