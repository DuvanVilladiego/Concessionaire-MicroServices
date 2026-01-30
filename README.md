# Concessionaire-Microservices

This project uses Java 17 with Spring Boot 3.2.5 and is composed of three microservices:

1. **Car Service**: A standalone microservice that performs its own tasks independently.
2. **Concessionaire Service**: A microservice that consumes the Car Service via HTTP.
3. **Messaging Service (query-logs)**: A microservice that receives transactions from the previous services and logs them to the console using ActiveMQ.

## Requirements

* Java 17
* Spring Boot
* Maven
* ActiveMQ
* PostgreSQL
* MongoDB

## Configuration

For proper service configuration, it is recommended to use the settings defined in the `application.properties` files of each component.

### Car Service

This microservice runs independently and does not require additional configuration.

### Concessionaire Service

This microservice makes HTTP calls to the Car Service.

### Messaging Service (query-logs)

This microservice uses ActiveMQ to receive messages about request statuses and displays them in the console. Configure the ActiveMQ properties in `application.properties`:

```properties
# Configuration example
spring.activemq.broker-url=tcp://localhost:61616
spring.activemq.user=admin
spring.activemq.password=admin
```

## Execution

1. Clone the repository:

   ```sh
   git clone https://github.com/DuvanVilladiego/Concessionaire-MicroServices.git
   ```

2. Navigate to the project directory:

   ```sh
   cd concessionaire-microservices
   ```

3. Run the SQL script in your database (cars):

   ```sh
   psql -U root -d cars -f Concessionaire.sql
   ```

4. Build and package the microservices with Maven:

   ```sh
   mvn clean install
   ```

5. Run each microservice:

   ```sh
   # Car Service
   java -jar springboot-test-car/target/springboot-test-car-0.0.1-SNAPSHOT.jar

   # Concessionaire Service
   java -jar springboot-test-concessionarie/target/springboot-test-concessionarie-0.0.1-SNAPSHOT.jar

   # Messaging Service
   java -jar springboot-test-query-log/target/springboot-test-query-log-0.0.1-SNAPSHOT.jar
   ```

## Additional Notes

* Make sure ActiveMQ is running before starting the Messaging Service.
* Check the logs of each service to verify that they are communicating correctly.
* The repository includes a Postman collection to facilitate service testing:
  `Concessionaire.postman_collection`
