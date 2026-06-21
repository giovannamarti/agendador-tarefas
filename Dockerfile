FROM eclipse-temurin:21 as build
WORKDIR /app
COPY . .
RUN ./gradlew build --no-daemon

FROM eclipse-temurin:21

WORKDIR /app

COPY --from=build /app/build/libs/*jar /app/agendador-tarefas.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/agendador-tarefas.jar"]
