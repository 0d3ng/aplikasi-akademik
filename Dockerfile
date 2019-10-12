FROM java:8-jdk-alpine
COPY ./target/aplikasiakademik/ /tmp
WORKDIR /tmp
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "aplikasiakademik.jar"]