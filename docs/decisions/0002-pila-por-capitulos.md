# 0002. Pila por capítulos

**Fecha:** 2026-10-23
**Estado:** aceptada (Abraham Kalume, 2026-10-23)

## Contexto

El proyecto tiene que lucir en un portfolio, con una pila reconocible y un resultado que se pueda enseñar. Es un sistema
multipropósito y, por rendimiento, parte del núcleo de cálculo podría migrar más adelante a C++ o a Rust. Se quiere ir
de menos a más: primero que funcione y se entienda, después optimizar.

## Decisión

- **Capítulo 1:** Java y Spring Boot, Maven, PostgreSQL, Spring Data JPA con Flyway, Picocli.
- **Java 25, la última versión LTS**, para todo el proyecto (código y tests), con la versión fijada en un solo sitio
  del `pom.xml`. Se descartó Java 21 con un JDK más nuevo para compilar, porque obligaba a mantener dos versiones.
- **El núcleo de cálculo** vive detrás de la interfaz `Calculator`, como funciones puras: no conoce Spring, ni la base de
  datos, ni la red. Recibe y devuelve datos simples.
- **De menos a más:** el núcleo se escribe y se prueba primero en Java puro, sin Spring ni base de datos. Spring entra
  cuando hace falta (primer `@RestController` en el Paso 6).
- **La pasarela** es un paquete de la misma aplicación hasta que haya un segundo servicio real al que enrutar.
- **Capítulo 2:** núcleo en Rust o C++, solo después de medir (Paso 10).

## Alternativas descartadas y por qué

| Decisión | Elegida | Alternativa | Cambia de opinión si |
| --- | --- | --- | --- |
| Lenguaje y framework | Java con Spring Boot | Python, reutilizando lo de MHWilds | Se prioriza ir rápido sobre lucir en portfolio |
| Construcción | Maven, con su wrapper `mvnw` | Gradle | Se prefiere la sintaxis de Gradle |
| Base de datos | PostgreSQL | SQL Server | El entorno o la entrega exige SQL Server |
| Persistencia | Spring Data JPA con Flyway | JDBC a mano | Se quiere controlar cada consulta |
| CLI | Picocli | Spring Shell | Se quiere una consola interactiva y no comandos sueltos |
| Pasarela | Dentro de la misma aplicación, separada por paquetes | Spring Cloud Gateway como servicio aparte | Existe un segundo servicio real al que enrutar |
| Núcleo de cálculo | Java primero, tras la interfaz | Escribirlo ya en Rust o C++ | Las medidas del Paso 10 muestran que Java no llega |
| Versión de Java | 25 (LTS) | 21 (LTS anterior) | Spring Boot o una librería deja de soportar la 25 |

## Lo que no se decide hoy

- La autenticación de jugadores y de servicios (Paso 8).
- Qué lenguaje nativo y cómo se une a Java (Paso 10, con medidas).
- El frontend web: queda fuera de esta guía.

## Consecuencias

- Los tests del núcleo describen su comportamiento, no su lenguaje (test de contrato): los mismos servirán para una
  versión en Rust o C++.
- Es más fácil partir una aplicación bien separada que unir servicios mal cortados.
- Java 25 se probó en un proyecto de pruebas con Spring Boot 3.5.16: compila con `release 25` y pasan 86 tests con el
  JDK 25.0.1. No se ha comprobado todavía en este repositorio que la pila compile: eso ocurre en el Paso 4.
- Con Java 25 en todo el proyecto, la API de funciones externas (FFM, definitiva desde Java 22) queda disponible para el
  núcleo nativo del Paso 10 sin cambiar de versión.

## Revisar

Al terminar el Paso 10, o antes si cambia alguna de las condiciones de la última columna.
