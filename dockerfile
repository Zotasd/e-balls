# Etapa 1: build do app
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app

# Copia os arquivos do projeto e compila o jar
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: runtime da aplicação
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia o JAR gerado da etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta da aplicação (ajuste se não for 8080)
EXPOSE 8080

# Comando de execução
ENTRYPOINT ["java", "-jar", "app.jar"]