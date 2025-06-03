# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the jar (you must build this jar using Maven/Gradle)
COPY target/productservice-0.0.1-SNAPSHOT.jar app.jar

# Expose the app port
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
