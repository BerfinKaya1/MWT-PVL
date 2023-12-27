FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /app

COPY target/todo-backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]"]