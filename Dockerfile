# Use a lightweight OpenJDK image
FROM openjdk:17-jdk-slim

# Copy the built jar file
ADD target/tcsapperp.jar tcsapperp.jar

# Expose the port your app runs on (default Spring Boot port)
EXPOSE 9056

# Run the jar file
ENTRYPOINT ["java", "-jar", "tcsapperp.jar"]
