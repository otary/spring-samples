FROM openjdk:8-jdk-alpine
ADD ./target/spring-cloud-nacos-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 9837
