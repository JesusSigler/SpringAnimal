25/05/17

	Proyecto Spring jdbc version 1.0
	
	Este proyecto dispone de persistencia en una base de datos relacional: mysql
	
	Los datos referentes a la base de datos se encuentran en src/main/resources/META-INF/spring/database.properties

	Para desplegar la aplicación se requiere instalar maven, posteriormente abrir el terminal e introducir los siguientes comandos:
	
	mvn package
	mvn jetty:run

	hay una alternativa a usar el pluging de jetty que sería coger el archivo .war generado por el comando mvn package e introducirlo en la carpeta webapp de tomcat, 
	por tanto además deberías tener instalado tomcat si queremos usar este método.
	
	a continuación abriremos el navegador e introduciremos la siguiente url:
	
	localhost:9999/animal/add
	
	Esta url la utilizaremos ya que no existe ningún dato aún en la base de datos, podéis ver las distintas opciones disponibles mirando el archivo:

	src/main/java/com/aula/controller/AnimalController.java

	Una vez hayamos introducido el primer dato y pulsado en insertar, nos redireccionará a la vista de listar. 