FROM openjdk:8-jdk-alpine

RUN sh -c 'addgroup microservices'
RUN sh -c 'adduser -D usr_intake -g microservices'

RUN sh -c 'mkdir -p /user/local/microservices/intake/'
COPY *.jar /user/local/microservices/intake/app.jar

RUN sh -c 'touch /user/local/microservices/intake/app.jar'
RUN sh -c 'chown -R usr_intake:microservices /user/local/microservices/intake'

EXPOSE 8080

USER usr_intake
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/user/local/microservices/intake/app.jar"]




