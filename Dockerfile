FROM openjdk:17-jdk-slim

VOLUME /tmp

ARG JAR_FILE=target/stock-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /app/app.jar

COPY .env /app/.env

EXPOSE 8080

WORKDIR /app

ENTRYPOINT ["java","-jar","app.jar"]