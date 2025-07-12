     FROM maven:3.9.8-eclipse-temurin-23 AS build
     WORKDIR /app
     COPY pom.xml .
     COPY src ./src
     RUN mvn clean package -DskipTests
     FROM eclipse-temurin:23-jre
     WORKDIR /app
     COPY --from=build /app/target/gemini-chat-0.0.1-SNAPSHOT.jar .
     EXPOSE 8080
     CMD ["java", "-jar", "gemini-chat-0.0.1-SNAPSHOT.jar"]