# Stage 1: App build
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copy Maven dependencies configuration file
COPY pom.xml .

# Download dependencies in the container layer
RUN mvn dependency:go-offline -B

# Copy the application source code
COPY src ./src

# Package the application skipping tests for faster deployment
RUN mvn clean package -DskipTests -B

# Stage 2: Run image
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the packaged .jar from Stage 1, reducing the final image size
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar app.jar

# Render automatically assigns a port, we expose 8080 (used internally or locally)
EXPOSE 8080

# Only first command, using dynamic memory limit (75% of available RAM)
# This parameter prevents unexpected restarts due to lack of memory (OOM) in the free Render layer (512MB RAM)
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]
