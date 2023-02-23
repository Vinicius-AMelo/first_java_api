FROM maven:3.9.0-eclipse-temurin-17-alpine

WORKDIR /usr/src/app

COPY . /usr/src/app

EXPOSE 8080

ENV DATABASE_URL=172.17.0.3:5432

CMD ["java", "-jar", "target/first_api_java-0.0.1-SNAPSHOT.jar"]