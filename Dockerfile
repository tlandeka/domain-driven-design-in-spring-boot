#Docker image example
FROM openjdk:8-jre-alpine

COPY target/excercise-0.0.1-SNAPSHOT.jar /app.jar
# specify default command
CMD ["/usr/bin/java", "-jar", "/app.jar"]