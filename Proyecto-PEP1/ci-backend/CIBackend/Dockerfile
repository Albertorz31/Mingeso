FROM openjdk:11

RUN mkdir -p /app


WORKDIR /app
COPY target/docker-spring-boot.jar ./app.jar
EXPOSE 8080
CMD [ "java", "-jar", "./app.jar" ]
