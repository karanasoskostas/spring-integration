FROM openjdk:17-jdk
FROM openjdk:11
EXPOSE 8080
ADD target/integration.jar integration.jar
#ENTRYPOINT ["java","-Duser.timezone=GMT --spring.config.location=file:application.properties", "-jar","integration.jar"]
ENTRYPOINT ["java","-Duser.timezone=GMT " , "-jar","integration.jar"]

#FROM openjdk:11  AS builder
#WORKDIR source
#ARG JAR_FILE=target/integration*.jar
#COPY ${JAR_FILE} integration.jar
#RUN jar -xf ./integration.jar
#
#FROM openjdk:11
#WORKDIR integration
#COPY --from=builder source/BOOT-INF/lib lib
#COPY --from=builder source/META-INF app/META-INF
#COPY --from=builder source/BOOT-INF/classes app
#ENTRYPOINT ["java","-Duser.timezone=GMT", "-cp","app:lib/*","pydra.integration.IntegrationApplication"]
