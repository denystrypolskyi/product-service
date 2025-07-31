# Product Service

This microservice is responsible for managing products. It supports creating, retrieving, updating, deleting products, and decrementing product stock in batches.

## 🚀 Features

- Retrieve all products — get a list of all available products.
- Retrieve product by ID — get detailed information about a specific product.
- Create new products — add new products to the catalog.
- Update existing products — modify details of existing products.
- Delete products — remove products from the catalog.
- Batch decrement product quantities — reduce stock quantities for multiple products in one request.

## 📌 Endpoints

| Method   | Endpoint                    | Description                                | Authentication Required          |
|----------|-----------------------------|--------------------------------------------|--------------------------------|
| **GET**  | `/products`                 | Get all products                           | No                             |
| **GET**  | `/products/{id}`            | Get a product by ID                        | No                             |
| **POST** | `/products`                 | Create a new product                       | Yes                            |
| **PUT**  | `/products/{id}`            | Update product details                     | Yes                            |
| **DELETE** | `/products/{id}`          | Delete a product                           | Yes                            |
| **PUT**  | `/products/decrement-batch` | Decrement quantities for multiple products | Yes                            |    

## 🔐 Security

- Currently, any authenticated user can create, update, or delete products.
- In production, role-based access control would be added to restrict sensitive operations.

## 📦 Tech Stack

- Java 24  
- Spring Boot  
- Jakarta Validation  
- PostgreSQL  
- Lombok  
