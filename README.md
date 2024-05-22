# Concessionaire-Microservices

Este proyecto utiliza Java 17 con Spring Boot 3.2.5 y está compuesto por tres microservicios:

1. **Servicio Car**: Un microservicio autónomo que realiza sus propias tareas.
2. **Servicio Concessionaire**: Un microservicio que consume el Servicio Car a través de HTTP.
3. **Servicio de Mensajería (query-logs)**: Un microservicio que recibe y muestra por consola el estado de las peticiones de los dos servicios anteriores mediante ActiveMQ.

## Requisitos

- Java 17
- Maven
- ActiveMQ
- Postgres

## Configuración

Para la correcta configuración del servicio, se recomienda usar las configuraciones establecidas en los archivos `application.properties` de cada componente.

### Servicio Car

Este microservicio funciona de forma autónoma y no requiere configuraciones adicionales.

### Servicio Concessionaire

Este microservicio realiza llamadas HTTP al Servicio Car.

### Servicio de Mensajería (query-logs)

Este microservicio utiliza ActiveMQ para recibir mensajes sobre el estado de las peticiones y las muestra en consola. Configura las propiedades de ActiveMQ en el `application.properties`:

```properties
# Ejemplo de configuración
spring.activemq.broker-url=tcp://localhost:61616
spring.activemq.user=admin
spring.activemq.password=admin
```

## Ejecución

1. Clona el repositorio:
   ```sh
   git clone https://github.com/DuvanVilladiego/Concessionaire-MicroServices.git
   ```

2. Navega al directorio del proyecto:
   ```sh
   cd concessionaire-microservices
   ```

3. Compila y empaqueta los microservicios con Maven:
   ```sh
   mvn clean install
   ```

4. Ejecuta cada microservicio:
   ```sh
   # Servicio Car
   java -jar springboot-test-car/target/springboot-test-car-0.0.1-SNAPSHOT.jar

   # Servicio Concesionarios
   java -jar springboot-test-concessionarie/target/springboot-test-concessionarie-0.0.1-SNAPSHOT.jar

   # Servicio de Mensajería
   java -jar springboot-test-query-log/target/springboot-test-query-log-0.0.1-SNAPSHOT.jar
   ```

## Notas Adicionales

- Asegúrate de que ActiveMQ esté corriendo antes de iniciar el Servicio de Mensajería.
- Revisa los logs de cada servicio para verificar que se están comunicando correctamente.
El repositorio incluye una coleccion de Postman para falicitar la prueba de los servicios `Concessionaire.postman_collection`.