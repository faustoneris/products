package com.fier.products.modules.models.entity.auctions;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Auctions")
public class Auction {

    @Id
    private String id;
    private double auctionMinimumPrice;
    private double auctionPrice;
    private String productId;
    private AuctionOwner auctionOwner;
    private int quantityProduct;

    public double getAuctionMinimumPrice() {
        return auctionMinimumPrice;
    }

    public AuctionOwner getAuctionOwner() {
        return auctionOwner;
    }

    public double getAuctionPrice() {
        return auctionPrice;
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }


}
