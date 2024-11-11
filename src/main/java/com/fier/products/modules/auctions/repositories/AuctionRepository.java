package com.fier.products.modules.auctions.repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.fier.products.modules.models.entity.auctions.Auction;

import org.springframework.data.mongodb.core.query.Query;

@Repository
public class AuctionRepository {

    private final MongoTemplate mongoTemplate;
    public AuctionRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void createAuction(Auction auction) {
        this.mongoTemplate.save(auction);
    }

    public List<Auction> fetchAuctionBySupplier(String document) {
         var query = new Query()
            .addCriteria(Criteria.where("document").is(document));
        return this.mongoTemplate.find(query, Auction.class);
    }

}
