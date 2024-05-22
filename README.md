Concessionaire-Microservices
Este proyecto utiliza Java 17 con Spring Boot 3.2.5 y está compuesto por tres microservicios:

Servicio Independiente: Un microservicio autónomo que realiza sus propias tareas.
Servicio Consumidor: Un microservicio que consume el Servicio Independiente a través de HTTP.
Servicio de Mensajería: Un microservicio que recibe y gestiona el estado de las peticiones de los dos servicios anteriores mediante ActiveMQ.
Requisitos
Java 17
Maven
ActiveMQ
Configuración
Para la correcta configuración del servicio, se recomienda usar las configuraciones establecidas en los archivos application.properties de cada componente.

Servicio Independiente
Este microservicio funciona de forma autónoma y no requiere configuraciones adicionales para comunicarse con otros servicios.

Servicio Consumidor
Este microservicio realiza llamadas HTTP al Servicio Independiente. Asegúrate de configurar la URL del Servicio Independiente en el application.properties del Servicio Consumidor:

properties
Copy code
# Ejemplo de configuración
service.independent.url=http://localhost:8080/api/independent
Servicio de Mensajería
Este microservicio utiliza ActiveMQ para recibir mensajes sobre el estado de las peticiones. Configura las propiedades de ActiveMQ en el application.properties:

properties
Copy code
# Ejemplo de configuración
spring.activemq.broker-url=tcp://localhost:61616
spring.activemq.user=admin
spring.activemq.password=admin
Ejecución
Clona el repositorio:

sh
Copy code
git clone https://github.com/tu_usuario/concessionaire-microservices.git
Navega al directorio del proyecto:

sh
Copy code
cd concessionaire-microservices
Compila y empaqueta los microservicios con Maven:

sh
Copy code
mvn clean install
Ejecuta cada microservicio:

sh
Copy code
# Servicio Independiente
java -jar independent-service/target/independent-service.jar

# Servicio Consumidor
java -jar consumer-service/target/consumer-service.jar

# Servicio de Mensajería
java -jar messaging-service/target/messaging-service.jar
Notas Adicionales
Asegúrate de que ActiveMQ esté corriendo antes de iniciar el Servicio de Mensajería.
Revisa los logs de cada servicio para verificar que se están comunicando correctamente.