# Use Maven with OpenJDK 21 for the build stage
FROM openjdk:21-jdk-slim AS build

# Install Maven manually since we're using a pure OpenJDK image
RUN apt-get update && apt-get install -y maven

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the project
RUN mvn clean install

# Use OpenJDK 21 for running the application
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR from the Maven build image
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 3000

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
