FROM openjdk:8-jdk-alpine

LABEL maintainer="heena.mittal@nagarro.com"

ADD target/aggregator-0.0.1-SNAPSHOT.jar aggregator-0.0.1-SNAPSHOT.jar

EXPOSE 9107

ENTRYPOINT ["java", "-jar","aggregator-0.0.1-SNAPSHOT.jar"]