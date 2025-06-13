# Use official OpenJDK runtime as base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw.cmd mvnw.cmd
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (Windows compatible)
RUN ./mvnw.cmd dependency:go-offline -B

# Copy source code
COPY src src

# Build the application
RUN ./mvnw.cmd clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/viatab-backend-1.0.0.jar"]
