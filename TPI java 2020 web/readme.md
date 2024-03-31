# <a name="_5enbj5t62an6"></a>**Lenguaje de Programación Java - TP Desarrollo 2020**
<a name="_u39iowmq62k5"></a>Integrantes:

44795 Mateo, Lara Ailén Iris 

45313 Arcari, Hernán David

# <a name="_w7w0e1pjo0fa"></a>***Sistema de adopción de mascotas*** 
Observando las problemáticas de comunicación entre Refugios, personas que hacen tránsito de mascotas y personas con deseo de adoptar decidimos plantear un sistema de adopción de animales que los reúna para lograr así mayor difusión, logrando disminuir los animales callejeros y que no logran ser adoptados.

En nuestro sistema notamos que lamentablemente algunos animales son dados en adopción muchas veces, ya sea por falta de adaptación en el nuevo hogar, o por necesidad de la persona que lo tenía en tránsito. Por las razones mencionadas, llevamos registro de quienes son las mascotas que están en la página.

El proceso de adopción sucede así:

1. Usuario Donante publica la Mascota a dar en adopción.
1. Usuario Adoptante busca animales en adopción.
1. Usuario Adoptante elige Mascota de su preferencia y el sistema registra la adopción.


Tipos de usuario: Administrador, Usuario.


# <a name="_p0elxlqozxu"></a>***Sistema de vacunaciones***
Como un agregado de valor al sistema de adopción de mascotas, podrán registrarse vacunaciones realizadas a las mascotas publicadas, para llevar un registro para el adoptante de las vacunas aplicadas y que este pueda saber cuales deberá aplicar a la mascota en caso de adopción. Cuando se publique una mascota, esta se dará de alta sin vacunaciones aplicadas, luego el usuario podrá registrar las vacunas que haya aplicado a esta mascota:

1. El usuario donante, publica una mascota
1. El usuario donante da de alta ninguna, una o varias vacunaciones aplicadas a la mascota.
1. Usuario adoptante, ve en el listado de tránsitos las vacunaciones aplicadas a cada mascota.
1. El usuario adoptante puede comparar las vacunas aplicadas a la mascota, con el listado general, dondé verá para qué especie es cada vacuna.

Tipos de usuario: Administrador, Usuario.
# <a name="_egh10mnh1ff"></a>Modelo de dominio/modelo de datos 

<https://drive.google.com/file/d/163m80mWTdbfIR7upT8VmSNA9Xo8ucMkY/view?usp=sharing>
# <a name="_mpj48bmidtk4"></a>Requerimientos funcionales
1. Gestión de Usuarios
1. Gestión de Mascotas
1. Gestión de Localidad
1. Gestión de Adopción
1. Informe de mascotas disponibles para adoptar por Localidad
1. Gestión de vacunas.
1. Gestión de vacunaciones.

## <a name="_t2whkjan8zty"></a>Lista del NOMBRE de los Casos de Uso/User Stories de cada requerimiento funcional
Req1	CU1 ABMC de Usuario

Req2	CU2 ABMC de Localidad

Req3	CU3 ABMC de Mascota

Req4	CU4 ABMC de Adopción

Req5 CU5 ABMC de vacunas

Req6 CU6 ABMC de vacunaciones

## <a name="_rshjygtnpebc"></a>Lista del NOMBRE de los Casos de Uso/User Stories de cada requerimiento funcional para la AP DIRECTA.
Req5 CU5 Informar Mascotas por Localidad
# <a name="_ya9hae50wle7"></a>Regularidad

|**Requerimiento**|<p>**cant. máx.**</p><p>**3 o 4 integ**</p>|**Detalle/Listado de casos incluidos**|
| :-: | :-: | :-: |
|ABMC simple|1 x integ|<p>CU1 ABMC de Usuario</p><p>CU2 ABMC de Localidad</p><p>CU3 ABMC de Mascota</p>|
|ABMC dependiente|2|Localidad-Usuario y Adopción|
|CU NO-ABMC|2|Para realizar una adopción, el usuario debe ser usuario registrado|
|Listado simple|3|Usuario, Localidad, Mascota|
|Listado complejo|1||
# <a name="_i7vme49ibwjp"></a>Aprobación Directa

|**Requerimiento**|<p>**cant. máx.**</p><p>**3 o 4 integ**</p>|**Detalle/Listado de casos incluidos**|
| :-: | :-: | :-: |
|ABMC|todos||
|CU "Complejo"(nivel resumen)|2|<p>CUC1 - Adopción mascota</p><p>CUC2 - ABM Vacunaciones</p>|
|Listado complejo|<p>2</p><p></p>|Transitos|
|Nivel de acceso|2|Administrador, Usuario |
|Manejo de errores|obligatorio|no requiere detalle |
|requerimiento extra obligatorio (\*\*)|1 - cambió a 0 por 2 part.||
|publicar el sitio|obligatorio|no requiere detalle|
## <a name="_wotvjwiysxys"></a>Requerimientos extra - AD

|**Requerimiento**|**Detalle/Listado de casos incluidos**|
| :-: | :-: |
|Manejo de archivos||
|Custom exceptions||
|Log de errores||
|Envío de emails||

