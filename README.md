# User Management API

A RESTful User Management API built with Spring Boot to practice backend development fundamentals and clean API design.

## Features

- Create, Read, Update, and Delete (CRUD) operations
- Request and Response DTOs
- Input Validation using Jakarta Validation
- Global Exception Handling
- RESTful API design
- HTTP Status Code handling
- MySQL database integration with Spring Data JPA

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Lombok
- Maven
- Jakarta Validation

## API Endpoints

| Method | Endpoint | Description |
|----------|----------|-------------|
| POST | `/user/create` | Create a user |
| GET | `/users` | Get all users |
| GET | `/user/{id}` | Get user by ID |
| PUT | `/user/edit` | Update user |
| DELETE | `/user/delete/{id}` | Delete user |
