FROM openjdk:11

RUN mkdir -p /app


WORKDIR /app
COPY target/ASJV.backend-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "./app.jar"]