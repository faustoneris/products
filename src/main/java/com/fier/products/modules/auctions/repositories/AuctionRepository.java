package com.fier.products.modules.auctions.repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.fier.products.modules.models.entity.auctions.Auction;
import com.fier.products.modules.models.entity.auctions.AuctionStatus;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@Repository
public class AuctionRepository {

    private final MongoTemplate mongoTemplate;
    public AuctionRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void createAuction(Auction auction) {
        auction.setStatus(AuctionStatus.WAITING);
        this.mongoTemplate.save(auction);
    }

    public List<Auction> fetchAuctionBySupplier(String document) {
         var query = new Query()
            .addCriteria(Criteria.where("supplierDocument").is(document));
        return this.mongoTemplate.find(query, Auction.class);
    }

    public Auction fetchAuctionByProductId(String productId) {
        var query = new Query()
           .addCriteria(Criteria.where("productId").is(productId));
       return this.mongoTemplate.findOne(query, Auction.class);
   }

    public boolean acceptAuctionPropose(String productId) {
        var query = new Query()
            .addCriteria(Criteria.where("productId").is(productId));
        var update = new Update()
            .set("status", AuctionStatus.ACCEPT);
        var updated = this.mongoTemplate.updateFirst(query, update, Auction.class);
        return updated.getModifiedCount() > 0;
    }

    public boolean refusedAuctionPropose(String productId) {
        var query = new Query()
            .addCriteria(Criteria.where("productId").is(productId));
        var update = new Update()
            .set("status", AuctionStatus.REFUSED);
        var updated = this.mongoTemplate.updateFirst(query, update, Auction.class);
        return updated.getModifiedCount() > 0;
    }

}
