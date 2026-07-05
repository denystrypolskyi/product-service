# Product Service

Product catalog service for the distributed backend system. It manages product data and stock quantities used during order creation.

## Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Security
- Spring Data JPA
- PostgreSQL
- Flyway
- Bean Validation
- JUnit, Mockito, MockMvc

## API

| Method | Endpoint | Auth | Description |
| --- | --- | --- | --- |
| `GET` | `/products` | No | List all products |
| `GET` | `/products/{id}` | No | Get a product by ID |
| `POST` | `/products` | Yes | Create a product |
| `PUT` | `/products/{id}` | Yes | Update a product |
| `DELETE` | `/products/{id}` | Yes | Delete a product |
| `PUT` | `/products/decrement-batch` | Yes | Decrease stock for multiple products |

### Product Request

```json
{
  "name": "Keyboard",
  "description": "Mechanical keyboard",
  "price": 99.99,
  "quantity": 10
}
```

### Batch Decrement Request

```json
[
  {
    "productId": 1,
    "quantity": 2
  }
]
```

## Notes

- Write operations require a valid JWT bearer token.
- Batch stock decrement is transactional.
- Product entities use optimistic locking to reduce concurrent stock update issues.

## Run Tests

```powershell
.\mvnw.cmd test
```
