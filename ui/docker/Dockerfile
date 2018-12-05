FROM openjdk:8-jdk-alpine

RUN sh -c 'groupadd microservices'
RUN sh -c 'useradd ui_user -g microservices'
RUN sh -c 'mkdir /user/local/microservices/ui/'
COPY *.jar /user/local/microservices/ui/app.jar

RUN sh -c ' touch /user/local/microservices/ui/app.jar'
RUN sh -c 'chown -R ui_user:microservices /user/local/microservices/ui'

EXPOSE 8081

USER ui_user
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/user/local/microservices/ui/app.jar"]