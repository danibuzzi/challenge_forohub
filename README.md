# Challenge ONE - Back End Java + Spring - API Rest Foro HUB.

![Badge Release](https://img.shields.io/badge/Release%20Date:-Julio-blue)``
![Badge Java](https://img.shields.io/badge/Java:-17-blue)
![Badge Java](https://img.shields.io/badge/Spring%20Boot:-3.5.3-blue)
![Badge Finalizado](https://img.shields.io/badge/Status:-Finalzado-blue)

## Descripción del Proyecto

Es la resolución del **Challenge - Foro Hub** utilizando **Spring Boot** para la creacion de la API Rest, **MySQL** para las bases de datos y **Java 17** para el desarrollo con ayuda del IDE de **Intellij** e **Insomnia** para las respectivas pruebas a la API. Cuarto reto de la formación **Oracle Next Education (ONE)** de **Oracle + Alura LATAM**.

El reto cosiste en crear una **API** implementando las mejores practicas del modelo **Rest** con validaciones y una implementación de una base de datos para la persistancia de la información.

### Historia

El _Foro HUb_ es un simil  de la plataforma Foro Alura donde los usuarios pueden colocar sus preguntas sobre determinados cursos, este mágico lugar está lleno de mucho aprendizaje y de colaboración entre alumnos, profesores y moderadores.

Ya sabemos para que sirve el foro y sabemos cómo se ve, pero ¿sabemos cómo funciona por detrás? Es decir, ¿dónde se almacena la información? ¿cómo se tratan esos datos para que se relacione un tópico con una respuesta, o como se relacionan los usuarios con las respuestas de un tópico?


Nuestra **API** va a permitirá a los usuarios:

### :hammer:Funcionalidades

- `Funcionalidad 1`: Crear un nuevo tópico.
- `Funcionalidad 2`: Mostrar todos los tópicos creados.
- `Funcionalidad 3`: Mostrar un tópico específico.
- `Funcionalidad 4`: Actualizar un tópico.
- `Funcionalidad 5`: Crear un nuevo usuario.
- `Funcionalidad 6`: Mostrar todos los usuarios creados.
- `Funcionalidad 7`: Mostrar un usuario específico.
- `Funcionalidad 8`: Actualizar un usuario.
- `Funcionalidad 9`: Eliminar un usuario.
- `Funcionalidad 10`: Crear un nuevo curso.
- `Funcionalidad 11`: Mostrar todos los cursos creados.
- `Funcionalidad 12`: Mostrar un curso específico.
- `Funcionalidad 13`: Actualizar un curso.
- `Funcionalidad 14`: Eliminar un curso.
- `Funcionalidad 15`: Crear una nueva respuesta a un tópico.
- `Funcionalidad 16`: Mostrar todas las respuestas creadas.
- `Funcionalidad 17`: Mostrar una respuesta específica.
- `Funcionalidad 18`: Actualizar una respuesta.
- `Funcionalidad 19`: Eliminar  una respuesta.
- `Funcionalidad 20`: API con rutas implementadas siguiendo las mejores prácticas del modelo Rest.
- `Funcionalidad 21`: Validaciones realizadas según reglas del negócio.
- `Funcionalidad 22`: Implementación de una base de datos para la persistencia de la información mediante mysql.

## Comenzando 🚀

Para probar el proyecto de forma local debe descargar una copia en formato zip de este repositorio o clónelo en su máquina. 


### Pre-requisitos 📋

Para instalar el software precisa tener instalado el SDK para java verión 17 mademas de instalar de forma local el gesto de  base de datos mysql.También precisa instalar Insomnia para efectuar las pruebas de las diferentes rutas de la API y sus funcionalidades.



### Instalación 🔧

-Abra el proeycto en el IDE  y después luego debe cree en mysql la base de datos ForoHub.
-Compile y ejecute el proyecto.
-Agregue un usuario en la tabla usuarios de forma manual.
-Mediante Insomia efectuar el login de usuario para obtener el token de autenticación JWT.
-Agregar datos a las tablas en el siguieten orden:
-Agregue datos a la tabla usuarios,
-Agregue datos a la tabla cursos.
-Agregue datos a la tabla topicos.
-Agregue datos a la tabla respuestas.
-Ahora podra realizar consultas , modifaciones , alta , eliminación de datos de en las diferentes tablas del sistema.



### algunos ejemplos de uso 🔧

-Conectarse mediante POST http://localhost:8080/usuarios e ingresar el JSON y  con datos de usuario para dar de alta y el token JWT.
-Las modificaciones de datos en el caso de esta tabla se efectuaran en PUT http://localhost:8080/usuarios
-Se puede consultar los datos de la tabla usuarios en GET http://localhost:8080/usuarios o consutlar el detalle de un usuario GET 
 http://localhost:8080/usuarios/id.
-La eliminacion de datos se hace en DELETE http://localhost:8080/usuarios/id.
-De manera similar puede hacer alta , modificacion,consulta y eliminación de datos de las restantes tablas (tener en cuenta que deberá agregar el Token JWT generado en el login del usuario).


## Construido con 🛠️

_Para desarrollar el proyecto, utilice las siguientes herramientas:_

* [Trello](https://trello.com/es) - Herramienta de gestión de proyectos.
* [MySQL](https://www.mysql.com/) - Sistema de gestión de bases de datos.
* [Java 17](https://www.oracle.com/java/) - Lenguaje de programación.
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - Entorno de desarrollo integrado para el desarrollo de programas informáticos.
* [Spring Boot](https://start.spring.io/) - Herramienta que hace que el desarrollo de aplicaciones web y microservicios con Spring Framework sea más rápido y fácil.
* [Insomnia](https://insomnia.rest/download) - Heramienta para testeo de la APi rest construida pudiendo ingresar rutas para ALta , Actualización ,Consulta y Eliminacion de Datos relativos al foro , json , tokenJWT de autenticación. 
## Autores ✒️
* * **Daniel Alejandro Buzzi** - *Alumo especializacion Java Backend* - [Daniel](https://www.linkedin.com/in/daniel/)
