FROM amd64/eclipse-temurin:11.0.13_8-jre-alpine
RUN mkdir /opt/wisdumb
COPY target/wisdumb*.jar /opt/wisdumb/wisdumb.jar
EXPOSE 8080
CMD ["java", "-jar", "/opt/wisdumb/wisdumb.jar"]
