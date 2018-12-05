FROM openjdk:8-jdk-alpine

RUN sh -c 'groupadd microservices'
RUN sh -c 'useradd ui_intake -g microservices'
RUN sh -c 'mkdir /user/local/microservices/intake/'
COPY *.jar /user/local/microservices/intake/app.jar

RUN sh -c 'touch /user/local/microservices/intake/app.jar'
RUN sh -c 'chown -R ui_intake:microservices /user/local/microservices/intake'

EXPOSE 8080

USER ui_intake
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/user/local/microservices/intake/app.jar"]


