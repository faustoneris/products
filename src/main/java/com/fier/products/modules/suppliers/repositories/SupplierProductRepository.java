package com.fier.products.modules.suppliers.repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    public boolean updateProduct(String productId, Product product) {
        var query = new Query()
            .addCriteria(Criteria.where("_id").is(productId));

        var update = new Update()
            .set("name", product.getName())
            .set("document", product.getDocument())
            .set("price", product.getPrice())
            .set("image", product.getImage())
            .set("category", product.getCategory())
            .set("minAuctionPrice", product.getMinAuctionPrice())
            .set("specifications", product.getSpecifications());

        var updated = this.mongoTemplate.updateFirst(query, update, Product.class);

        return updated.getModifiedCount() > 0;
    }

    public void deleteProduct(String productId) {
        var query = new Query()
            .addCriteria(Criteria.where("_id").is(productId));
        this.mongoTemplate.remove(query, Product.class);
    }
}
