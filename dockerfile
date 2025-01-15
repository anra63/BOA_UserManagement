# Use an OpenJDK 17 image as the base
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY build/libs/BOA_UserManagement-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application runs on (optional but recommended)
EXPOSE 8083

# Set the command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
# CONTAINER ID   IMAGE              COMMAND               CREATED              STATUS              PORTS                    NAMES
  #9169e2785ee9   usermanagementms   "java -jar app.jar"   About a minute ago   Up About a minute   0.0.0.0:8084->8083/tcp   usermanagementms-containe