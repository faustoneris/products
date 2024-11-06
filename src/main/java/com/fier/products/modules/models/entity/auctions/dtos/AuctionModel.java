package com.fier.products.modules.models.entity.auctions.dtos;

import com.fier.products.modules.models.entity.auctions.AuctionOwner;

public class AuctionModel {

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

    public void validate() {
        if (this.getProductId().isEmpty())
            throw new Error("Produto inválido");
        if (this.getAuctionMinimumPrice() <= 0)
            throw new Error("Preço minimo inválido");
        if (this.getAuctionOwner() == null)
            throw new Error("Dados do cliente inválido");
        if (this.getAuctionPrice() <= 0 || this.getAuctionPrice() < this.getAuctionPrice())
            throw new Error("Lance inválido");
    }

}
