# 🍕 Pizza Kata - Starter

Welcome to the Pizza Kata!

## 📌 Submission Guidelines

To help us understand your approach and thought process, please follow these guidelines:

* **Fork this repository** (or copy it into your own GitHub/GitLab project).
* **Commit regularly** with meaningful commit messages. This helps us follow your reasoning during the refactor and feature implementation.
* We strongly prefer to see your **development history**. A single final commit makes it difficult to assess your approach.
* You may submit your solution as a link to a **public Git repository**, or as a **ZIP file**.
* ⚠️ **If there is no Git history**, we cannot properly evaluate your solution.

Good luck and enjoy the kata! 🍀

## ✅ Reminder: your application should still work

After refactoring and extending the code, your application should still be functional.  
We will run a small script to verify that everything works as expected.

Please make sure:

- The project still builds successfully
- The `/order` endpoint still behaves correctly
- Any new features (like toppings) are properly integrated

Tip: test everything before you submit. A clean and modular solution is great — but working code is even better 😉
## Goal

You are given a working but poorly structured Spring Boot application that handles pizza orders. Your task is to:

1. Refactor the code using SOLID and Clean Code principles.
2. Add support for custom pizza toppings.
3. Replace in-memory H2 database with a real PostgreSQL container via Testcontainers.

## Technologies

- Java 21 (LTS)
- Spring Boot 3.5+
- JUnit 5
- Mockito
- Testcontainers
- Maven

## Endpoint

`POST /order`

```json
{
  "pizza": "MARGHERITA",
  "size": "MEDIUM"
}
````

Response:

```json
{
  "orderId": "123e4567-e89b-12d3-a456-426614174000",
  "estimatedTime": "20 minutes"
}
```

## Phase 1 – Refactoring

Refactor to:

* Extract logic from controllers
* Use constructor injection
* Improve naming
* Add unit and integration tests
* Introduce domain models

## Phase 2 – Enhancement

Support toppings like `EXTRA_CHEESE` and `OLIVES`, each adding 2 minutes to the estimated time.

> Enjoy and good luck!

## 🐳 Docker Support

A sample `compose.yml` is included. If you prefer to run a PostgreSQL container instead of using H2, simply add the following dependency in your maven file.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-docker-compose</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

Make sure to adjust `application.properties` accordingly to point to the containerized PostgreSQL instance.
