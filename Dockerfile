FROM gradle:9.4.0-jdk25 AS build
WORKDIR /app

# Copy the build files first to leverage Docker cache
COPY build.gradle* settings.gradle* ./
# Copy the source code
COPY src ./src

# Build the jar (skipping tests for speed)
RUN gradle clean build -x test

# Stage 2: Create the runtime image
FROM openjdk:25-ea-jre-slim
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

ENV JAVA_OPTS="-Xmx512m"

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]