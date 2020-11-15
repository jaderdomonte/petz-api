FROM openjdk:8-jdk-alpine
ARG JAR_FILE=./target/petz-api.jar
WORKDIR .
COPY ${JAR_FILE} petz-api.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev-postgres", "/petz-api.jar"]