FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY gemini-chat-backend/pom.xml .
COPY gemini-chat-backend/src ./src
RUN mvn clean package -DskipTests
FROM  eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/gemini-chat-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "gemini-chat-0.0.1-SNAPSHOT.jar"]