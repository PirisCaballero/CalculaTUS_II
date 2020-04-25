# CalculaTUS_II
Second part of CalculaTUS

Repositorio del proyecto del Grupo 10:

Desarrollo en Java 1.8 (Oracle) y constriudo con Maven.

Maven -> Herramienta de software para la gestión y construcción de proyectos Java.
https://maven.apache.org/guides/index.html

MySQL -> Sistema de gestión de bases de datos relacional SGBD.
https://dev.mysql.com/doc/

JUnit -> JUnit es un conjunto de bibliotecas que son utilizadas en programación para hacer pruebas unitarias.
https://junit.org/junit4/

JaCoCo -> Se utiliza para realizar reportes con base en la métrica de code coverage.
https://www.jacoco.org/jacoco/trunk/doc/

Mockito -> Proporcionar la capacidad de escribir con claridad una prueba de unidad legible.
https://site.mockito.org/

Instalar:

mvn validate -> Valida que el proyecto es correcto y toda la información necesaria está disponible.

mvn compile -> Compila el código fuente del proyecto.

mvn install -> Descarga dependencias.

Ejecutar:
mvn exec:java -Dexec.mainClass="com.mycompany.app.ventanas.VentanaLogin" -> Ejecuta la clase principal.

	- Para registrarte debes introducir tu nombre, apellido, correo, contraseña y tipo de cuenta.

		- En caso de ser un usuario, deberás introducir el correo de tu jefe o responsable.

		- Si fueras un administrador, no tendrás que rellenar el campo "Correo de Administrador".

	- Desde VentanaLogin, introduce tu correo y contraseña para poder usar el programa.

		- Si eres un usuario normal podrás hacer las siguientes acciones:

			- Registrar local.

			- Hacer ticket.

			- Ver tickets.

			- Ver productos.

			 -Ver estadística.

		- Si además eres un administrador*[1] podrás hacer uso de las pestañas "Admin" y "FTP".

		- Si quieres salir, tan solo tienes que cerrar la ventana; tambien existe la opción de "Log out" que permite cerrar sesión sin cerrar el programa para que otro usuario pueda iniciar sesión.

	- [1] Por defecto cuando creamos una cuenta esta nunca sera administrador, esta funcion solo podra concederla otro administrador a una cuenta normal (o el programador accediendo a la base de datos).

Pruebas automatizadas:

mvn test -> Prueba el código fuente compilado utilizando un Framework de testeo adecuado.

mvn prueba de integración -> Procesa e implementa el paquete si es necesario en un entorno donde se puedan ejecutar pruebas de testeo.

Pasos a seguir en caso de errores Maven:

1->	mvn validate

2->	mvn compile

3->	mvn test

4->	mvn package

5->	mvn integration-test

6->	mvn verify

7->	mvn install