<%@page import="entities.Vacunacion"%>
<%@page import="logic.VacunacionLogic"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Vacuna"%>
<%@page import="logic.VacunaLogic"%>
<%@page import="entities.Usuario"%>
<%@page import="entities.Mascota"%>
<%@page import="logic.CtrlMas"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Cargar vacunación</title>
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
String e = (String) request.getAttribute("estado");
%>
<%
CtrlMas ctrlMas = new CtrlMas();
Usuario u = (Usuario) session.getAttribute("usuario");
LinkedList<Mascota> mascotas = ctrlMas.getMascotasByUser(u.getId());
VacunacionLogic vacunacionLogic = new VacunacionLogic();
LinkedList<Vacunacion> vacunaciones = vacunacionLogic.getAll();
%>
</head>
<body>

	<div class="limiter">
				<a href="Signin" class="btn-flotante">↩</a>
		<%
		if (e != null) {
		%>
		<div>
			<h2 class="text-center snack"><%=e%></h2>
		</div>
		<%
		}
		%>
		<div class="container-login100"
			style="background-image: url('images/cachorros.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" action="vacunacionbaja"
					method="post" id="formbajaVac">
					<span class="login100-form-title p-b-10"> AdoptAr </span> <span
						class="login100-form-subtitle p-b-20"> Mascotas felices en
						hogares felices! </span>

					<p class="text-center txt2 m-b-15">Borrar vacunación</p>

				<div class="wrap-input100 validate-input m-b-15"
						data-validate="Mascota requerida">
						<span class="label-input100">Mascota</span> <select
							class="input100" required id="selectMascota" name="selectMascota">
							<option value="">Elija mascota actual</option>
							<%
							for (Mascota mas : mascotas) {
							%>
							<option value="<%=mas.getId()%>"><%=mas.getNombre()%></option>
							<%
							}
							%>
						</select> <span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					
					
				<div class="wrap-input100 validate-input m-b-15"
						data-validate="Vacuna requerida">
						<span class="label-input100">Vacuna</span> <select
							class="input100" required id="selectVacuna" name="selectVacuna">
							<option value="">Elija vacuna</option>							
						</select> <span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>		

					<div class="container-login100-form-btn m-t-25">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">Aceptar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<div id="dropDownSelect1"></div>


	<script>
	    document.getElementById('selectMascota').addEventListener('change', function() {
	        var selectedMascotaId = this.value;
	        var selectVacuna = document.getElementById('selectVacuna');
	        selectVacuna.innerHTML = ''; // Limpiar las opciones anteriores
	        
	        var especie
	
	        // Iterar sobre las vacunas y agregar las que correspondan a la mascota seleccionada
	        <% for (Mascota mas : mascotas) { %>
		        if ('<%= mas.getId() %>' === selectedMascotaId) {
	                mascota = '<%= mas.getId() %>';	                
	            }
	        <% } %>
            var empty = document.createElement('option');
            empty.value = '';
            empty.text = 'Elija vacuna'
	        selectVacuna.appendChild(empty);
            let cant = 0
	        <% for (Vacunacion vac : vacunaciones) { %>
	                if ('<%= vac.getId_mascota() %>' ===  mascota) {
	                	cant++
	                    var option = document.createElement('option');
	                    option.value = '<%= vac.getId_vacunacion() %>';
	                    option.text = '<%= vac.getVacuna().getTitulo() %>- Aplicada en ' + new Date('<%= vac.getFecha_vacunacion() %>').toLocaleDateString() ;
	                    selectVacuna.appendChild(option);
	                }	           
	        <% } %>
	        if (cant == 0){
	        	if(document.getElementById('vacio'))
		        	document.getElementById('formbajaVac').removeChild(document.getElementById('vacio'))
	        	let errorEl = document.createElement('span')
	        	errorEl.innerHTML = 'La mascota no tiene vacunas'
	        	errorEl.id = 'vacio'
	        	document.getElementById('formbajaVac').appendChild(errorEl)
	        } else {
	        	if(document.getElementById('vacio'))
		        	document.getElementById('formbajaVac').removeChild(document.getElementById('vacio'))
	        }
	        	
	    });
	</script>

	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>