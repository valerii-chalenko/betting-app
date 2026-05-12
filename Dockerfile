FROM amazoncorretto:25-alpine

VOLUME /tmp
COPY target/*.jar application.jar
ENTRYPOINT ["java","-jar","/application.jar"]
