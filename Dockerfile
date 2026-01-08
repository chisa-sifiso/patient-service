# 1️⃣ Base image (Java 17)
FROM eclipse-temurin:17-jdk-alpine

# 2️⃣ Set working directory inside container
WORKDIR /app

# 3️⃣ Copy the built jar into container
COPY target/patient-service-0.0.1-SNAPSHOT.jar app.jar

# 4️⃣ Expose Spring Boot port
EXPOSE 8080

# 5️⃣ Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
