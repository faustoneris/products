package com.fier.products.modules.customers.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.fier.products.modules.customers.services.ProductsService;
import com.fier.products.modules.models.entity.Feedback;
import com.fier.products.modules.models.entity.Product;

@RestController
@RequestMapping("/customer/products")
public class ProductController {

    private final ProductsService productService;

    public ProductController(ProductsService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> fetchProducts() {
        return this.productService.fetchProducts();
    }

    @GetMapping("{id}")
    public Product fetchProductById(@PathVariable String id) {
        return this.productService.fetchProductById(id);
    }

    @GetMapping("categories/{category}")
    public List<Product> fetchProductsByCategory(@PathVariable String category) {
        return this.productService.fetchProductsByCategory(category);
    }

    @PutMapping("feedback/{productId}")
    public boolean createFeedback(@PathVariable String productId, @RequestBody Feedback entity) {
        return this.productService.createFeedbacks(productId, entity);
    }
}
