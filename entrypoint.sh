#!/bin/bash

export DATABASE_URL=db
mvn package
java -jar target/first_api_java-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod