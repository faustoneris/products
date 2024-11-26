package com.fier.products.modules.models.entity.auctions;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Auctions")
public class Auction {

    @Id
    private String id;
    private BigDecimal auctionMinimumPrice;
    private BigDecimal auctionPrice;
    private String productId;
    private String supplierDocument;
    private AuctionOwner auctionOwner;
    private int quantityProduct;
    private AuctionStatus status;

    public BigDecimal getAuctionMinimumPrice() {
        return auctionMinimumPrice;
    }

    public AuctionOwner getAuctionOwner() {
        return auctionOwner;
    }

    public BigDecimal getAuctionPrice() {
        return auctionPrice;
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getSupplierDocument() {
        return supplierDocument;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public AuctionStatus getStatus() {
        return status;
    }

    public void setStatus(AuctionStatus status) {
        this.status = status;
    }


}
