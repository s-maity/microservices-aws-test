FROM --platform=linux/amd64 amazoncorretto:17-alpine-jdk
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]