#docker build --tag nexus3-registry.okd.pyramidchallenges.com/request-api:1.1 .
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY intake-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
