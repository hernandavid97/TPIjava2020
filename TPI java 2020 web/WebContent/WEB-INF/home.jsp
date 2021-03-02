<%@page import="entities.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="zxx">

<head>
	<title>Home - AdoptAr</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords" content="Electro Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"
	/>
	<script>
		addEventListener("load", function () {
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

	<!-- web fonts -->
	<link href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i&amp;subset=latin-ext" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	    rel="stylesheet">
	<!-- //web fonts -->
	<% Usuario u = (Usuario)session.getAttribute("usuario"); %>
</head>

<body>
	<h2> <%= u.getNombre() %> <%=u.getApellido() %> </h2>
	<%if (u.getTipo()==0){ %>
	<a href="localidaddelete">Baja Localidad</a>
	<a href="localidadmod">Modificar Localidad</a>
	<a href="localidadadd">Alta Localidad</a>
	<%} %>
	<a href="mascotaadd">Donar Mascota</a>
	<a href="logout">Cerrar Sesión</a>
</body>

</html>