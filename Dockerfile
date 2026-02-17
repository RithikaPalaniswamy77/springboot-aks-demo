# Stage 1: Build the JAR
FROM maven:3.9.3-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create runtime image
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/target/AKS-Handson-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 7001
ENTRYPOINT ["java","-jar","app.jar"]

