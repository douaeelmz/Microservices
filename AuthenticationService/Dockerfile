# Docker Build Maven Stage
FROM maven:3.8.4-openjdk-17 AS build
# Copy folder in docker
WORKDIR /opt/app
COPY ./ /opt/app
COPY src/main/resources/application-docker.properties /opt/app/src/main/resources/application.properties
RUN mvn clean install -DskipTests

FROM openjdk:17
COPY --from=build /opt/app/target/*.jar AuthenticationService.jar
COPY src/main/resources/application-docker.properties /app/application.properties
ENV PORT 8081
EXPOSE $PORT
ENTRYPOINT ["java","-jar","-Xmx1024M","-Dserver.port=${PORT}","AuthenticationService.jar"]
