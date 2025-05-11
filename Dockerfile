# Etapa 1: build da aplicação
FROM gradle:8.5-jdk17 AS build
WORKDIR /app
COPY --chown=gradle:gradle . .
RUN gradle build -x test

# Etapa 2: imagem de execução com JDK
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
