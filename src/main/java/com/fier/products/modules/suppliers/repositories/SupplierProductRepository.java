package com.fier.products.modules.suppliers.repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.fier.products.modules.models.entity.products.Product;

@Repository
public class SupplierProductRepository {
    private final MongoTemplate mongoTemplate;

    public SupplierProductRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Product> fetchProductByDocument(String document) {
        var query = new Query()
            .addCriteria(Criteria.where("document").is(document));

        return this.mongoTemplate.find(query, Product.class);
    }

    public Product createProduct(Product product) {
        return this.mongoTemplate.save(product);
    }

    public void deleteProduct(String productId) {
        var query = new Query()
            .addCriteria(Criteria.where("_id").is(productId));
        this.mongoTemplate.remove(query, Product.class);
    }
}
