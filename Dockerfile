# Stage 1: Construcción de la aplicación (Build)
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copiamos el archivo de configuración de dependencias de Maven
COPY pom.xml .

# Descargamos las dependencias necesarias en la capa del contenedor
# Esto ahorra tiempo en construcciones sucesivas si el pom.xml no cambia
RUN mvn dependency:go-offline -B

# Copiamos el código fuente de la aplicación
COPY src ./src

# Empaquetamos la aplicación ignorando las pruebas para mayor velocidad de despliegue
RUN mvn clean package -DskipTests -B

# Stage 2: Imagen de ejecución (Run)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiamos únicamente el .jar empaquetado del Stage 1, lo cual reduce el tamaño de la imagen final
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar app.jar

# Render automáticamente asignará un puerto, nosotros exponemos el 8080 (usado internamente o localmente)
EXPOSE 8080

# Definimos el comando de inicio, utilizando el límite de memoria dinámica (75% de la RAM disponible)
# Este parámetro previene reinicios inesperados por falta de memoria (OOM) en la capa gratuita de Render (512MB RAM)
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]
