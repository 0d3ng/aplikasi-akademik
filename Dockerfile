FROM maven:3.6.3-openjdk-8-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B -f pom.xml clean package -DskipTests

FROM openjdk:8-jdk-alpine
MAINTAINER Noprianto <lepengdados@gmail.com>

RUN apk add --no-cache bash
RUN apk add --no-cache curl

COPY --from=build /workspace/target/*.jar /opt/app.jar

RUN bash -c 'touch /opt/app.jar'