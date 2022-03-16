# For Java 8
# FROM openjdk:8-jdk-alpine

# For Java 11
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/customer-phonenumber-validation-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/customer-phonenumber-validation-0.0.1-SNAPSHOT.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]

## docker run -p 8080:8080 -t docker-spring-boot:1.0
## docker run -p 80:8080 -t docker-spring-boot:1.0
## docker run -p 443:8443 -t docker-spring-boot:1.0