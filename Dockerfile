FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/clientService-1.0.jar clientservice.jar
ENTRYPOINT ["java","-jar","/clientservice.jar"]