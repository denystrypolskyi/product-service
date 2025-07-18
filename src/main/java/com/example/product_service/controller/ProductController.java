package com.example.product_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_service.dto.ProductDTO;
import com.example.product_service.dto.ProductDecrementRequest;
import com.example.product_service.model.Product;
import com.example.product_service.service.ProductService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        Product created = service.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/decrement-batch")
    public ResponseEntity<Void> decrementProductQuantities(
            @Valid @RequestBody List<@Valid ProductDecrementRequest> requests) {
        service.decrementQuantities(requests);
        return ResponseEntity.ok().build();
    }
}
