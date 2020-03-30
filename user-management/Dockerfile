FROM openjdk:8-jdk-alpine

LABEL maintainer="heena.mittal@nagarro.com"

ADD target/user-management-0.0.1-SNAPSHOT.jar user-management-0.0.1-SNAPSHOT.jar

EXPOSE 9106

ENTRYPOINT ["java", "-jar","user-management-0.0.1-SNAPSHOT.jar"]