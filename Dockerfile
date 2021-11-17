FROM openjdk:17-jdk

EXPOSE 8080

ADD target/artifacts/integration_jar/integration.jar integration.jar

ENTRYPOINT ["java","-jar","integration.jar"]