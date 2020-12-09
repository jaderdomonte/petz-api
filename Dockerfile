FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/petz-api.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/app.jar"]