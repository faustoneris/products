package com.fier.products.modules.customers.repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.fier.products.modules.models.entity.auctions.AuctionStatus;
import com.fier.products.modules.models.entity.products.Feedback;
import com.fier.products.modules.models.entity.products.Product;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@Repository
public class ProductRepository {

    private final MongoTemplate mongoTemplate;

    public ProductRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Product> fetchProducts() {
        return this.mongoTemplate.findAll(Product.class);
    }

    public Product fetchProductById(String id) {
        var query = new Query()
            .addCriteria(Criteria.where("_id").is(id));

        return this.mongoTemplate.findOne(query, Product.class);
    }

    public List<Product> fetchProductsByCategory(String category) {
        var query = new Query()
            .addCriteria(Criteria.where("category").is(category));

        return this.mongoTemplate.find(query, Product.class);
    }

    public boolean changeProductAuctionStatus(String productId, AuctionStatus status) {
        var query = new Query()
            .addCriteria(Criteria.where("_id").is(productId));
        var update = new Update()
            .set("auctionStatus", status);
        var updated = this.mongoTemplate.updateFirst(query, update, Product.class);
        return updated.getModifiedCount() > 0;
    }

    public boolean createFeedback(String productId, Feedback feedback) {
        var query = new Query()
            .addCriteria(Criteria.where("_id").is(productId));
        var update = new Update()
            .push("feedbacks", feedback);
        var updated = this.mongoTemplate.updateFirst(query, update, Product.class);

        return updated.getMatchedCount() > 0;
    }

}
