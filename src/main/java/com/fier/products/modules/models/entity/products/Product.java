package com.fier.products.modules.models.entity.products;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Products")
public class Product {
    @Id
    private String id;
    private String name;
    private String document;
    private BigDecimal price;
    private String image;
    private String category;
    private BigDecimal minAuctionPrice;
    private List<Feedback> feedbacks;
    private Specifications specifications;

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Specifications getSpecifications() {
        return specifications;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public String getId() {
        return id;
    }

    public String getDocument() {
        return document;
    }

    public BigDecimal getMinAuctionPrice() {
        return minAuctionPrice;
    }
}
