FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/examen-vehiculo-0.0.1.jar
COPY ${JAR_FILE} examen-vehiculo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","examen-vehiculo.jar"]