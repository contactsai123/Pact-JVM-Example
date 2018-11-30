FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8111
ARG JAR_FILE=build/libs/PACT-JVM-1.0.0.jar
COPY ${JAR_FILE} PACT-JVM-1.0.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/PACT-JVM-1.0.0.jar"]