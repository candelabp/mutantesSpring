# Proyecto: **Detector de Mutantes**

Este proyecto es una aplicación backend desarrollada con **Spring Boot** que permite identificar si un humano es mutante o no, basado en su secuencia de ADN. La secuencia de ADN es recibida en un formato específico, y a partir de la misma se realizan verificaciones para determinar si contiene patrones mutantes.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot**
- **Gradle**
- **Jakarta Persistence (JPA)**
- **Lombok** para reducir el código.
- **H2 Database** para pruebas locales
- **Postman** (para pruebas de API)
- **DockerFile**


## Funcionalidades

1. **Detección de Mutantes**: Dada una secuencia de ADN, la API evalúa si corresponde a un humano mutante o no.
2. **Persistencia**: Los humanos, mutantes o no, se almacenan en una base de datos.
3. **API REST**: El sistema expone endpoints para la creación y consulta de humanos y sus secuencias de ADN.
   
## Estructura del Proyecto

El proyecto sigue una arquitectura organizada en capas, facilitando la mantenibilidad y escalabilidad del sistema.

- **Controladores**: Exponen los endpoints de la API REST.
- **Servicios**: Contienen la lógica de negocio, como la detección de mutantes.
- **Repositorio**: Interactúa con la base de datos utilizando JPA.

### Entidades Principales:

- **Humano**: Esta entidad representa a un ser humano con su secuencia de ADN y el estado de si es o no mutante.

### Diagrama de Entidades:

## Instalación y Configuración

### Prerrequisitos

- **Java 17** instalado
- **Gradle** instalado
- **MySQL** (o un motor de base de datos alternativo)
- **Postman** para pruebas de API

### Clonar el proyecto


git clone https://github.com/candelabp/mutantesSpring.git
cd proyecto-mutante

### Despliegue en Render

La API está desplegada en Render y puedes acceder a la siguiente ruta:

- [Link Render](https://mutantesspring.onrender.com/)
## Funcionalidades de la API
- *POST* /personas/mutant: Verifica si un ADN pertenece a un mutante.
  - URL: https://mutantesspring.onrender.com/humanos
  
- *GET* /stats: Retorna las estadísticas de mutantes y humanos.
  - URL: https://mutantesspring.onrender.com/humanos/stats


- *GET* /humanos/{id}: Devuelve una persona por ID.
  - URL: https://mutantesspring.onrender.com/personas/1


