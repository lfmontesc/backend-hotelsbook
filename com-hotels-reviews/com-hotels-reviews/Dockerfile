#inicia con la imagen base que contiene java runtime
FROM openjdk:21-jdk-slim as build

#se agrega el jar del microservicio al contenedor
COPY target/com-hotels-reviews-0.0.1-SNAPSHOT.jar com-hotels-reviews-0.0.1-SNAPSHOT.jar

#se ejecuta el microservicio
ENTRYPOINT ["java","-jar","/com-hotels-reviews-0.0.1-SNAPSHOT.jar"]