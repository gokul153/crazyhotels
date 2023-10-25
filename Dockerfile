# Use a base image with a Java Runtime Environment
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY ./target/availablehotel-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application listens on
EXPOSE 8080

# Command to run your application
CMD ["java", "-jar", "app.jar"]
