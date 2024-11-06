package com.fier.products.modules.auctions.services;

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
        // auction.validate();
        this.auctionRepository.createAuction(auction);
    }
}
