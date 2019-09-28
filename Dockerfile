FROM openjdk:11

VOLUME /tmp

EXPOSE 80 443

ARG jarPath

WORKDIR /opt/app/

COPY ${jarPath} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
