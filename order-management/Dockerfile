FROM openjdk:8-jdk-alpine

LABEL maintainer="heena.mittal@nagarro.com"

ADD target/order-management-0.0.1-SNAPSHOT.jar order-management-0.0.1-SNAPSHOT.jar

EXPOSE 9105

ENTRYPOINT ["java", "-jar","order-management-0.0.1-SNAPSHOT.jar"]