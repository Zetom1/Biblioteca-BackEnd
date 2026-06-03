# Sistema de Gestión de Biblioteca - Backend 📚☕

Este repositorio contiene la API REST para el Sistema de Gestión de Biblioteca. Está construido utilizando **Java** y **Spring Boot**, siguiendo una arquitectura limpia en capas (Controller, Service, Repository) para asegurar la escalabilidad y mantenibilidad del código.

La API se encarga de centralizar las reglas de negocio de la aplicación, gestionar la persistencia de datos y exponer los endpoints necesarios para que el frontend pueda interactuar con el sistema.

*Enlace al repositorio del Frontend:* [Repositorio Frontend - Vue 3](https://github.com/Zetom1/Biblioteca-Frontend)

---

## 🛠️ Tecnologías Utilizadas

- **Java 17 / 21**
- **Spring Boot 3.x**
- **Spring Data JPA** (Persistencia y ORM)
- **PostgreSQL / MySQL** (Base de datos relacional)
- **Maven** (Gestor de dependencias)

## 🏗️ Arquitectura y Características

El diseño del backend implementa lógica de negocio desacoplada con un flujo de datos estricto:
- **Modelo/Entity:** Entidad `Book` estructurada con campos clave (`id`, `titulo`, `reserva`, `cantidad`).
- **Repository (Capa DAO):** Extiende de `JpaRepository` abstrayendo las consultas complejas de SQL y automatizando el acceso a los datos.
- **Service (Capa de Negocio):** Centraliza la lógica principal del sistema, como el control de inventario transaccional y las reglas de validación para el **Préstamo** y **Devolución** de libros.
- **Controller (Capa REST):** Expone los endpoints HTTP con mapeos semánticos claros (`GET`, `POST`, `PUT`, `DELETE`).

## 🛣️ Endpoints Principales (API REST)

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `GET` | `/api/libros` | Obtiene el catálogo completo de libros. |
| `POST` | `/api/libros` | Registra un nuevo libro en el sistema. |
| `POST` | `/api/libros/{id}/prestar` | Procesa el préstamo restando una unidad (Lógica de control de stock). |
| `POST` | `/api/libros/{id}/devolver` | Registra la devolución sumando una unidad al stock disponible. |

## 🚀 Instrucciones de Configuración Local

### Requisitos Previos
- Java JDK instalado.
- Base de datos relacional (configurada en el puerto por defecto).

### Pasos para Ejecutar
1. Clona este repositorio:
   ```bash
   git clone [https://github.com/Zetom1/Biblioteca-BackEnd.git](https://github.com/Zetom1/Biblioteca-BackEnd.git)
