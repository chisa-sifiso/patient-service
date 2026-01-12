FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the already-built jar
COPY target/billling-service-0.0.1-SNAPSHOT.jar app.jar

# Expose ports
EXPOSE 4001
EXPOSE 9090

# Run Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
