package com.fier.products.modules.auctions.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fier.products.modules.auctions.services.AuctionService;
import com.fier.products.modules.models.entity.auctions.Auction;
import java.util.List;

@RestController
@RequestMapping("auctions")
public class AuctionController {

    private final AuctionService auctionService;
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping("supplier/{document}")
    public List<Auction> fetchAuctionBySupplier(@PathVariable String document) {
        return this.auctionService.fetchProductsBySupplier(document);
    }


    @PostMapping()
    public void createAuction(@RequestBody Auction auctionModel) {
        this.auctionService.createAuction(auctionModel);
    }
}
