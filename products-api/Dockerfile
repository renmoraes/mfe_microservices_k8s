FROM amazoncorretto:11-alpine-jdk
WORKDIR /app
COPY target/products-api-0.0.1-SNAPSHOT.jar /app/products-api.jar
CMD ["java", "-jar", "/app/products-api.jar"]