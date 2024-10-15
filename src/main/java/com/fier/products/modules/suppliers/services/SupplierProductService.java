package com.fier.products.modules.suppliers.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fier.products.modules.models.entity.Product;
import com.fier.products.modules.suppliers.repositories.SupplierProductRepository;

@Service
public class SupplierProductService {

    private final SupplierProductRepository supplierRepository;
    public SupplierProductService(SupplierProductRepository supplierProductRepository) {
        this.supplierRepository = supplierProductRepository;
    }

    public List<Product> fetchProductByDocument(String document) {
        return this.supplierRepository.fetchProductByDocument(document);
    }

    public Product createProduct(Product product) {
        return this.supplierRepository.createProduct(product);
    }

    public void deleteProduct(String productId) {
        this.supplierRepository.deleteProduct(productId);
    }
}
