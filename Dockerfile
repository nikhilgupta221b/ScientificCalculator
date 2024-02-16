FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/scientific-calculator-1.0-SNAPSHOT.jar /app/

#CMD ["java", "-jar", "scientific-calculator-1.0-SNAPSHOT.jar"]