<%@page import="entities.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="es">

<head>
<title>Home - AdoptAr</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords"
	content="Electro Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- //Meta tag Keywords -->

<!-- Custom-Files -->
<!--  <link href="css2/bootstrap.css" rel="stylesheet" type="text/css" media="all" /> -->
<!-- //Custom-Files -->
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

<!-- web fonts -->
<link
	href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i&amp;subset=latin-ext"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	rel="stylesheet">
<!-- //web fonts -->
<%
Usuario u = (Usuario) session.getAttribute("usuario");
%>
<%
String p = (String) request.getAttribute("permisos");
%>
</head>

<body>
	<div class="limiter">
		<%
			if (p != null) {
		%>
			<div>
				<h2 class="text-center snack" style="background: red;"><%=p%></h2>
			</div>
		<%
			}
		%>
		<div class="container-login100"
			style="background-image: url('images/cachorros.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-40 p-b-54">
				<h2 class="p-b-40" style="font-weight: 700;">
					Bienvenido
					<%=u.getNombre()%>
					<%=u.getApellido()%>
				</h2>
				<%
				if (u.getTipo() == 0) {
				%>
				<a href="usuariolist">Listado de Usuarios</a><br> <br> <a
					href="registrar">Alta Usuario</a><br> <br> <a
					href="localidadlist">Listado de localidades</a><br> <br>
				<a href="localidadadd">Crear Localidad</a><br> <br> <a
					href="localidadmod">Modificar Localidad</a><br> <br> <a
					href="localidaddelete">Eliminar Localidad</a> <br> <br> <a
					href="vacunaadd">Crear Vacuna</a><br> <br>
				<a href="vacunabaja">Eliminar Vacuna</a><br> <br>

				<div
					style="border: 1px solid white; width: 100%; height: 0px; margin-bottom: 20px;"></div>
				<a href="transitolist">Listado de Transitos</a><br> <br> <a
					href="mascotalist">Listado de Mascotas</a><br> <br> <a
					href="transitoadd">Publicar mascota en adopcion</a><br> <br>
				<a href="mascotamod">Modificar Mascotas</a> <br> <br> <a
					href="mascotadelete">Eliminar Mascota</a> <br> <br> <a
					href="vacunalist">Listado de Vacunas</a><br> <br>
				<div
					style="border: 1px solid white; width: 100%; height: 0px; margin-bottom: 20px;"></div>
				<a href="usuariomod">Modificar datos de Usuario</a><br> <br>
				<a href="usuariobaj">Eliminar Cuenta</a><br> <br> <a
					href="logout">Cerrar Sesion</a><br> <br>
				<%
				} else {
				%>
				<a href="transitolist">Listado de Transitos</a><br> <br> <a
					href="mascotalist">Listado de Mascotas</a><br> <br> <a
					href="mascotamod">Modificar Mascotas</a> <br> <br> <a
					href="transitoadd">Publicar mascota en adopcion</a><br> <br>
				<div
					style="border: 1px solid white; width: 100%; height: 0px; margin-bottom: 20px;"></div>
				<a href="usuariomod">Modificar datos de Usuario</a><br> <br>
				<a href="usuariobaj">Borrar Cuenta</a><br> <br> <a
					href="logout">Cerrar Sesion</a><br> <br>
				<%
				}
				%>


			</div>
		</div>
	</div>
</body>

</html>