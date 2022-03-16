## What is it?
This source code is an Spring Boot web application.
 
Tested with
* Docker 19.03
* Java 11
* Spring Boot 2.6.4.RELEASE
* Maven
* Junit

## How to run this?
```bash
$ git clone https://github.com/Osama-Makram/customer-phone-validation.git
$ cd customer-phone-validation
$ mvn clean package
$ java -jar target/customer-phonenumber-validation-0.0.1-SNAPSHOT.jar

  access http://localhost:8080

//dockerize

// create a docker image
$ docker build -t spring-boot:1.0 .
// run it
$ docker run -d -p 8080:8080 -t spring-boot:1.0

  access http://localhost:8080
```