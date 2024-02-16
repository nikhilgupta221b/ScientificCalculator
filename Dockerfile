FROM openjdk:11-jre-slim

WORKDIR /usr/src/app

COPY scientific-calculator-1.0-SNAPSHOT.jar .

CMD ["java", "-jar", "scientific-calculator-1.0-SNAPSHOT.jar"]