FROM eclipse-temurin:24-jdk-alpine

WORKDIR /app

COPY target/product-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
