FROM amazoncorretto:21-alpine

VOLUME /tmp
COPY target/*.jar application.jar
ENTRYPOINT ["java","-jar","/application.jar"]
