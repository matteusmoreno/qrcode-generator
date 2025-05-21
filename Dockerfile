FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8282

ARG AWS_ACCESS_KEY_ID
ARG AWS_SECRET_ACCESS_KEY

ENV AWS_S3_BUCKET_NAME=qrcode-storage-matteus-moreno
ENV AWS_S3_BUCKET_REGION=us-east-2

ENTRYPOINT ["java", "-jar", "app.jar"]