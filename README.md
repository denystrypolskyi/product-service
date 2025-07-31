# Product Service

This microservice is responsible for managing products. It allows creating, retrieving, updating, deleting, and decrementing product quantities.

## 🚀 Features

- **Get all products**  
  `GET /products` — Returns a list of all products.

- **Get product by ID**  
  `GET /products/{id}` — Returns a single product by its ID.

- **Create product**  
  `POST /products` — Adds a new product (🔒 authentication required).

- **Update product**  
  `PUT /products/{id}` — Updates product details (🔒 authentication required).

- **Delete product**  
  `DELETE /products/{id}` — Deletes a product (🔒 authentication required).

- **Batch decrement quantities**  
  `PUT /products/decrement-batch` — Decreases stock for multiple products (🔒 authentication required).

## 🔐 Security

- Endpoints that modify data are protected by a custom `@Authenticated` annotation.
- Currently, **any authenticated user** can create/update/delete products.

## 📦 Tech Stack

- Java 24
- Spring Boot
- Jakarta Validation
- PostgreSQL
- Lombok
