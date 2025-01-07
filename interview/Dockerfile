#FROM ghcr.io/graalvm/jdk-community:22 AS builder
#
#WORKDIR /app
#COPY mvnw  .
#COPY .mvn/wrapper/maven-wrapper.properties  ./.mvn/wrapper/
#COPY pom.xml .
#COPY src .
#
#RUN chmod a+x mvnw
#RUN ./mvnw package -DskipTests


FROM alpine/java:22-jre
WORKDIR /app
COPY target/app.jar app.jar
EXPOSE 8080
CMD [ "java", "-jar", "app.jar" ]