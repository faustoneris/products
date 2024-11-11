package com.fier.products.modules.auctions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fier.products.modules.auctions.repositories.AuctionRepository;
import com.fier.products.modules.models.entity.auctions.Auction;
import com.fier.products.modules.models.entity.auctions.dtos.AuctionModel;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;

    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public void createAuction(Auction auction) {
        this.auctionRepository.createAuction(auction);
    }

    public List<Auction> fetchProductsBySupplier(String document) {
        return this.auctionRepository.fetchAuctionBySupplier(document);
    }
}
