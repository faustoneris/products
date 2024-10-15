package com.fier.products.modules.customers.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fier.products.modules.customers.repositories.ProductRepository;
import com.fier.products.modules.models.entity.Feedback;
import com.fier.products.modules.models.entity.Product;

@Service
public class ProductsService {

    private final ProductRepository productRepository;
    public ProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> fetchProducts() {
        return this.productRepository.fetchProducts();
    }

    public Product fetchProductById(String id) {
        return this.productRepository.fetchProductById(id);
    }

    public List<Product> fetchProductsByCategory(String category) {
        return this.productRepository.fetchProductsByCategory(category);
    }

    public boolean createFeedbacks(String productId, Feedback feedback) {
        return this.productRepository.createFeedback(productId, feedback);
    }
}
