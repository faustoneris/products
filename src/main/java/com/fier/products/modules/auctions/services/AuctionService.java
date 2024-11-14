package com.fier.products.modules.auctions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fier.products.modules.auctions.repositories.AuctionRepository;
import com.fier.products.modules.customers.repositories.ProductRepository;
import com.fier.products.modules.models.entity.auctions.Auction;
import com.fier.products.modules.models.entity.auctions.AuctionStatus;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;
    private final ProductRepository productRepository;

    public AuctionService(AuctionRepository auctionRepository, ProductRepository productRepository) {
        this.auctionRepository = auctionRepository;
        this.productRepository = productRepository;
    }

    public void createAuction(Auction auction) {
        this.auctionRepository.createAuction(auction);
    }

    public List<Auction> fetchProductsBySupplier(String document) {
        return this.auctionRepository.fetchAuctionBySupplier(document);
    }

    public boolean acceptAuctionPropose(String productId) {
        var hasRefused = this.auctionRepository.acceptAuctionPropose(productId);
        if (hasRefused) {
            return this.productRepository.changeProductAuctionStatus(productId, AuctionStatus.ACCEPT);
        }
        return false;
    }

    public boolean refusedAuctionPropose(String productId) {
        var hasRefused = this.auctionRepository.refusedAuctionPropose(productId);
        if (hasRefused) {
            return this.productRepository.changeProductAuctionStatus(productId, AuctionStatus.REFUSED);
        }
        return false;
    }
}
