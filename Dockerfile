# Stage 1: Build the application using Maven
FROM maven:3.8.3-openjdk-17 as builder

# Set working directory inside the container
WORKDIR /app

# Copy the pom.xml and source code into the container
COPY pom.xml .
COPY src ./src
#RUN rm -rf target/*.jar
# Run Maven to build the application, skipping tests
RUN mvn clean package -DskipTests

# Stage 2: Create a minimal image with only the JAR file
FROM openjdk:17-jdk-alpine

# Set working directory for the runtime environment
WORKDIR /app

# Copy the JAR file from the previous stage
COPY --from=builder /app/target/*.jar app.jar

# Set entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]