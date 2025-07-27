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

    public Product createProduct(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        return repository.save(product);
    }

    public Optional<Product> delete(Long id) {
        return repository.findById(id)
                .map(product -> {
                    repository.deleteById(id);
                    return product;
                });
    }

    public Optional<Void> decrementQuantities(List<ProductDecrementRequest> requests) {
        for (ProductDecrementRequest req : requests) {
            Optional<Product> productOpt = repository.findById(req.getProductId());
            if (productOpt.isEmpty()) {
                return Optional.empty();
            }
            Product product = productOpt.get();

            if (product.getQuantity() < req.getQuantity()) {
                return Optional.empty();
            }

            product.setQuantity(product.getQuantity() - req.getQuantity());
            repository.save(product);
        }
        return Optional.of(null);
    }

    public Optional<Product> updateProduct(Long id, ProductDTO dto) {
        return repository.findById(id).map(product -> {
            product.setName(dto.getName());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());
            product.setQuantity(dto.getQuantity());
            return repository.save(product);
        });
    }
}