FROM eclipse-temurin:21-alpine
VOLUME /tmp
EXPOSE 8080

ARG JAR_FILE=target/findesk-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

RUN addgroup -S spring && adduser -S spring -G spring
USER spring

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
