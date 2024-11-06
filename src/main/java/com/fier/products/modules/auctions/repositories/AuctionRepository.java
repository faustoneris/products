package com.fier.products.modules.auctions.repositories;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.fier.products.modules.models.entity.auctions.Auction;
import com.fier.products.modules.models.entity.auctions.dtos.AuctionModel;

@Repository
public class AuctionRepository {

    private final MongoTemplate mongoTemplate;
    public AuctionRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void createAuction(Auction auction) {
        this.mongoTemplate.save(auction);
    }

}
