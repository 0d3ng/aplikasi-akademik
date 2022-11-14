FROM maven:3.6.3-openjdk-8-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY .docker/wait-for-it.sh /workspace
COPY src /workspace/src
RUN mvn -B -f pom.xml clean package -DskipTests

FROM openjdk:8-jdk-alpine
MAINTAINER Noprianto <lepengdados@gmail.com>

RUN apk add --no-cache bash
RUN apk add --no-cache curl

COPY --from=build /workspace/target/*.jar /opt/app.jar
COPY --from=build /workspace/wait-for-it.sh /opt/wait-for-it.sh
RUN chmod +x /opt/wait-for-it.sh

RUN bash -c 'touch /opt/app.jar'