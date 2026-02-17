# Use a lightweight OpenJDK 17 base image
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory inside the container
WORKDIR /app

# Define an argument for the JAR file name (assuming a Maven build outputs to target/)
ARG JAR_FILE=target/*.jar

# Copy the JAR file from the host to the container filesystem
COPY ${JAR_FILE} app.jar

EXPOSE 7001
# Define the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
