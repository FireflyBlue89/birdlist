FROM maven:3.8.7-openjdk-18-slim AS build

WORKDIR /birdapp

COPY . .

ENV JAVA_HOME='/usr/local/openjdk-18'
RUN mvn -f ./pom.xml clean package -DskipTests

FROM eclipse-temurin:23.0.2_7-jre-ubi9-minimal

COPY --from=build /birdapp/target/birdlist-1.0.jar /birdlist-1.0.jar
EXPOSE 8080

ENTRYPOINT java -jar /birdlist-1.0.jar

