#FROM openjdk:17-jdk
FROM openjdk:11

EXPOSE 8080

ADD target/integration.jar integration.jar

ENTRYPOINT ["java","-Duser.timezone=GMT", "-jar","integration.jar"]