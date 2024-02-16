FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/scientific-calculator.jar /app/