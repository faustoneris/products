package com.fier.products.modules.models.entity.emails;

import java.math.BigDecimal;

import com.fier.products.modules.models.entity.auctions.AuctionStatus;

public class EmailModel {

    private String username;
    private String productName;
    private BigDecimal auctionPrice;
    private String userEmail;
    private AuctionStatus auctionStatus;


    public EmailModel(String username, String productName, BigDecimal auctionPrice, String userEmail, AuctionStatus status) {
        this.auctionPrice = auctionPrice;
        this.auctionStatus = status;
        this.productName = productName;
        this.userEmail = userEmail;
        this.username = username;
    }


    public static EmailModel of(String username, String productName, BigDecimal auctionPrice, String userEmail, AuctionStatus status) {
        return new EmailModel(username, productName, auctionPrice, userEmail, status);
    }

    public BigDecimal getAuctionPrice() {
        return auctionPrice;
    }

    public AuctionStatus getAuctionStatus() {
        return auctionStatus;
    }

    public String getProductName() {
        return productName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUsername() {
        return username;
    }
}
