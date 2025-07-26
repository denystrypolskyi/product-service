package com.example.product_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.product_service.dto.ProductDTO;
import com.example.product_service.dto.ProductDecrementRequest;
import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    
    public List<Product> findAll() {
        return repository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product createProduct(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        return repository.save(product);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void decrementQuantities(List<ProductDecrementRequest> requests) {
        for (ProductDecrementRequest req : requests) {
            Product product = repository.findById(req.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getQuantity() < req.getQuantity()) {
                throw new RuntimeException("Not enough stock for product ID: " + req.getProductId());
            }

            product.setQuantity(product.getQuantity() - req.getQuantity());
            repository.save(product);
        }
    }
}
