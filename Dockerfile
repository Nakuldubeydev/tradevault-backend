FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY target/real-0.0.1-SNAPSHOT.jar  application.jar

EXPOSE 8080

ENTRYPOINT ["java","-XX:MaxRAMPercentage=75.0","-jar","application.jar"]
