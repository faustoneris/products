package com.fier.products.modules.suppliers.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fier.products.modules.models.entity.products.Product;
import com.fier.products.modules.suppliers.services.SupplierProductService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("supplier/product")
public class SupplierProductController {

    private final SupplierProductService supplierService;
    public SupplierProductController(SupplierProductService supplierProductService) {
        this.supplierService = supplierProductService;
    }

    @GetMapping("{document}")
    public List<Product> fetchProductByDocument(@PathVariable String document) {
        return this.supplierService.fetchProductByDocument(document);
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return this.supplierService.createProduct(product);
    }

    @PutMapping("{productId}")
    public boolean updateProduct(@PathVariable String productId, @RequestBody Product product) {
        return this.supplierService.updateProduct(productId, product);
    }

    @DeleteMapping("{productId}")
    public void deleteProduct(@PathVariable String productId) {
        this.supplierService.deleteProduct(productId);
    }

}
