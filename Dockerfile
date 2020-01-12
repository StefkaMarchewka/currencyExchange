
FROM maven:alpine

WORKDIR /app
COPY pom.xml ./pom.xml
COPY src ./src
RUN mvn package --batch-mode
RUN mvn clean package --batch-mode


FROM openjdk:8-jdk-alpine

COPY --from=0 /app/target/currencyExchange-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8080
WORKDIR /app
CMD ["java", "-jar", "currencyExchange-0.0.1-SNAPSHOT.jar"]
