FROM amd64/eclipse-temurin:11.0.13_8-jre-alpine
LABEL org.opencontainers.image.authors="Kevin Condon"
LABEL org.opencontainers.image.source="https://github.com/conivek/wisdumb"
RUN mkdir /opt/wisdumb
COPY target/wisdumb*.jar /opt/wisdumb/wisdumb.jar
EXPOSE 8080
CMD ["java", "-jar", "/opt/wisdumb/wisdumb.jar"]
