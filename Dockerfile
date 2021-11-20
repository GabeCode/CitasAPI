FROM openjdk:8-jdk-slim
COPY "./target/CitasAPI-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]