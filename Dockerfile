# Use an official OpenJDK 17 image as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container
COPY patient-system-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]

# /Users/gauthamsmacbook/Apps/Springboot\ Apps/patient-system
# docker build -t patient-service .
# docker build --platform linux/amd64/v3 -t patient-service .
# docker run -d -p 8080:8080 patient-service

