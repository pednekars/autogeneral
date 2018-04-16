# mycompany REST API


This project exposes some REST CRUD service for a mycompany.
It demonstrates the use of Spring-boot & Java 8.
An h2 in memory database has been used to store the mycompany data.

The restful services provide following functionality

validateBrackets of TaskController.java checks whether brackets are valid.
Eg {[]} is a valid bracket combination

Second is ToDoItemCOntroller which is used to store and retrieve todo
A ToDo will contain following things
ToDoItem text a String value of ToDoItem eg: "I have an appointment"
isCompleted to indicate whether todoitem is completed or not
 

**Important** : The project requires maven 3.x and a Java 8 jdk.

## 1. Installation

* Clone the github repository :
```
git clone https://github.com/pednekars/mycompany.git

mycompany is trade mark of mycompany. 

```

* Launch mvn clean install to build the project
```
mvn clean install -DskipTests
```
By default mvn clean install runs also the test units included in the project.
In the case of some unit test failed, you can run the following command :
```
mvn clean install -DskipTests
```

## 2. Set up server port and database configuration
The configuration file [application.properties](/mycompany-rest-api-core/src/main/resources/application.properties) allows you to change default parameters.

You can set-up the server port :
```
server.port=8080
```
You can set-up the database configuration :
```
#datasource
spring.datasource.url=jdbc:h2:mem:mydb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.path=/myconsole
spring.h2.console.enabled=true
spring.datasource.initialize=true
spring.datasource.schema=classpath:schema.sql
spring.datasource.data=classpath:import.sql
```
If you would like to use another database please don't forget to add the driver dependency in the pom.xml.

Ex :
```
<dependency>
 <groupId>com.oracle.jdbc</groupId>
 <artifactId>ojdbc7</artifactId>
 <version>12.1.0.2</version>
</dependency>
```

## 3. Launch the REST server

* Run mvn spring-boot:run in the mycompany-rest-api-web module to launch spring-boot server (a Tomcat is bundled by default)
```
cd mycompany-rest-api-web
mvn spring-boot:run

To test do following
Open Postman
Run following
To test valid brackets run following code
http://localhost:8080/tasks/validateBrackets?input=%7B%7B%7B%7B%7B%7B

To test to do item run following
http://localhost:8080/todo (http method = post)
Method body is as below and is of type json
 {
"id":1,
"text": "Hi how are you?.",
"isCompleted": "false",
"createdAt": "2017-10-13T01:50:58.735Z"
}


http://localhost:8080/todo/1 (http method = post). This will show what is already posted in previous url
```
Similarly you can try patch method

## 4. REST services documentation (Swagger)
The Rest services are documented with the Swagger api documentation available on these URL, once you run the server : [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


## 5. Run test units
To run only the test units run mvn test :
```
mvn test
```

## 6. Appendices

###Third party libraries used

You will find below the different third party libraries used in the project.

|Dependency|Benefits|
|-------|--------|
|[`spring-boot`](https://projects.spring.io/spring-boot/)|Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run"|
|[`swagger`](http://swagger.io/)|Swagger is a powerful open source framework backed by a large ecosystem of tools that helps you design, build, document, and consume your RESTful APIs.|
|[`h2database`](http://www.h2database.com/html/main.html)|Very fast, open source, JDBC API. Embedded and server modes; in-memory databases.|

## Potential enhancements
- Use Spring profile to allow multiple environments configuration.
- Add OAUTH2 or JWT security to retrieve a token for the frontend. The library spring-security could be used.
- Use Jpa transactions to handle concurrency
- Add a service layer to wrap dao call. Currently the dao are called from the rest controller.
- Add validation scenario
-- Add wiremock test




