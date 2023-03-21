FROM amazoncorretto:11-alpine-jdk
WORKDIR /app
COPY target/customer-api-0.0.1-SNAPSHOT.jar /app/customer-api.jar
CMD ["java", "-jar", "/app/customer-api.jar"]