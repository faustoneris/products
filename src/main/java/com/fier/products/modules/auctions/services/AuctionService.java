package com.fier.products.modules.auctions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fier.products.modules.auctions.repositories.AuctionRepository;
import com.fier.products.modules.customers.repositories.ProductRepository;
import com.fier.products.modules.models.entity.auctions.Auction;
import com.fier.products.modules.models.entity.auctions.AuctionStatus;
import com.fier.products.modules.models.entity.emails.EmailModel;
import com.fier.products.proxys.emails.Email;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;
    private final ProductRepository productRepository;
    private final Email emails;

    public AuctionService(AuctionRepository auctionRepository, ProductRepository productRepository, Email email) {
        this.auctionRepository = auctionRepository;
        this.productRepository = productRepository;
        this.emails = email;
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
            var auction = this.auctionRepository.fetchAuctionByProductId(productId);
            var product = this.productRepository.fetchProductById(productId);
            this.emails.sendEmailToUser(EmailModel.of(
                auction.getAuctionOwner().getName(),
                product.getName(),
                auction.getAuctionPrice(),
                auction.getAuctionOwner().getEmail(),
                AuctionStatus.ACCEPT));
            return this.productRepository.changeProductAuctionStatus(productId, AuctionStatus.ACCEPT);
        }
        return false;
    }

    public boolean refusedAuctionPropose(String productId) {
        var hasRefused = this.auctionRepository.refusedAuctionPropose(productId);
        if (hasRefused) {
            var auction = this.auctionRepository.fetchAuctionByProductId(productId);
            var product = this.productRepository.fetchProductById(productId);
            this.emails.sendEmailToUser(EmailModel.of(
                auction.getAuctionOwner().getName(),
                product.getName(),
                auction.getAuctionPrice(),
                auction.getAuctionOwner().getEmail(),
                AuctionStatus.REFUSED));
            return this.productRepository.changeProductAuctionStatus(productId, AuctionStatus.REFUSED);
        }
        return false;
    }
}
