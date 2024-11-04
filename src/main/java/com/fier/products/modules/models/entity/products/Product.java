package com.fier.products.modules.models.entity.products;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Products")
public class Product {
    @Id
    private String id;
    private String name;
    private String document;
    private int price;
    private String image;
    private String category;
    private List<Feedback> feedbacks;
    private Specifications specifications;

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
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
}
