FROM openjdk:8-jdk-alpine
RUN mkdir -p /src/api
WORKDIR /src/api
COPY target/*.jar api.jar
EXPOSE 8080
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prd","-jar","api.jar"]