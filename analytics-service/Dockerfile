# =========================
# 1️⃣ Build stage (Maven)
# =========================
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy only what's needed to build
COPY pom.xml .
COPY src ./src

# Build the Spring Boot jar
RUN mvn clean package -DskipTests


# =========================
# 2️⃣ Runtime stage (Java only)
# =========================
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose Spring Boot port
EXPOSE 4002


# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
