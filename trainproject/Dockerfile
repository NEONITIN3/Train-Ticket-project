FROM adoptopenjdk/openjdk15:jre-nightly
MAINTAINER Nitin Spring DevOps Team
EXPOSE 8080
ARG JAR_FILE
ENTRYPOINT ["java", "/app/app.jar"]
VOLUME /tmp
ADD $(JAR_FILE) /app/app.jar
