# E-commerce Price Service

## Descripción

Este proyecto es una prueba técnica, donde se requiere crear un servicio REST para obtener la informacion de precios de una tabla en una base de datos de prueba con varios parámetros de búsqueda (fecha de aplicación, identificador de producto, identificador de cadena).

El proyecto está diseñado con Arquitectura Hexagonal. La API Rest fue creada utilizando la herramienta Open API con el patrón delegado.

## Herramientas

Las siguientes son las herramientas, lenguaje, framework y librerías utilizadas:

- Java 17
- Spring Boot 3
- Spring Web
- Spring JPA
- Open API y Swagger
- Maven 4
- Base de datos H2
- Lombok
- JUnit 5 y Mockito
- Docker

## Compilación

Para compilar el proyecto se debe utilizar Maven, ejecutando el siguiente comando:

```bash
mvn clean package
```

Esto creará la carpeta *target* dentro del proyecto, donde está el código fuente de la API Rest diseñada y el archivo JAR.

## Ejecución

Para ejecutar la aplicación hay varias maneras:

### 1. Archivo JAR

Ejecutar el archivo Java que se genero después de realizar la compilación, con el siguiente comando:

```bash
java -jar PricesService-0.0.1-SNAPSHOT.jar
```

### 2. Aplicación Spring Boot

Ejecutar el proyecto Spring Boot, a través de Maven, ejecutando el siguiente comando:

```bash
mvn spring-boot:run
```

### 3. Imagen Docker

Descargar y ejecutar la imagen Docker que se encuentra en el repositorio de Docker Hub:

```bash
docker pull carlosmarinm/prices-service:v1
docker run -p 8080:8080 carlosmarinm/prices-service:v1
```

## Pruebas

Una vez levantada la aplicación, se puede realizar las pruebas del servicio REST con Swagger UI, accediendo a la URL [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html), donde se muestra una interfaz de usuario con los servicios Rest desplegados:

## Referencias

[https://www.baeldung.com/java-openapi-generator-server](https://www.baeldung.com/java-openapi-generator-server)

[https://medium.com/@espinozajge/desarrollo-rápido-de-apis-con-spring-boot-y-openapi-generator-6350bf7b8375](https://medium.com/@espinozajge/desarrollo-r%C3%A1pido-de-apis-con-spring-boot-y-openapi-generator-6350bf7b8375)

[https://reflectoring.io/spring-boot-openapi/](https://reflectoring.io/spring-boot-openapi/)

[https://reflectoring.io/spring-hexagonal/](https://reflectoring.io/spring-hexagonal/)

[https://betterprogramming.pub/hexagonal-architecture-with-spring-boot-74e93030eba3](https://betterprogramming.pub/hexagonal-architecture-with-spring-boot-74e93030eba3)