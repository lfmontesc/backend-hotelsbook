#inicia con la imagen base que contiene Java runtime
FROM openjdk:21-jdk-slim as build

#se agrega el jar del microservicio al contenedor
COPY target/com-hotels-hotel-0.0.1-SNAPSHOT.jar com-hotels-hotel-0.0.1-SNAPSHOT.jar

#se ejecuta el microservicio
ENTRYPOINT ["java","-jar","/com-hotels-hotel-0.0.1-SNAPSHOT.jar"]
