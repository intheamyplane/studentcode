package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {



    private AuctionDao dao;

    public AuctionController() {

        this.dao = new MemoryAuctionDao();
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Auction> list(
            @RequestParam (required = false) String title_like,
            @RequestParam (required = false) Double currentBid_lte) {

        if (title_like != null && currentBid_lte != null){
            return this.dao.searchByTitleAndPrice(title_like, currentBid_lte);
        }
        else if (title_like != null) {
            return this.dao.searchByTitle(title_like);
        } else if (currentBid_lte != null) {
            return this.dao.searchByPrice(currentBid_lte);
        } else {

            return dao.list();
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction getAuctionById (@PathVariable int id){
        return dao.get(id);
    }


    @PostMapping
    public Auction createAuction(@RequestBody Auction newAuction){
        return dao.create(newAuction, newAuction.getId());
    }




    }


