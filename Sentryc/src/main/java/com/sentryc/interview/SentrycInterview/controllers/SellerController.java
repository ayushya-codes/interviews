package com.sentryc.interview.SentrycInterview.controllers;

import com.sentryc.interview.SentrycInterview.dtos.Data;
import com.sentryc.interview.SentrycInterview.dtos.Params;
import com.sentryc.interview.SentrycInterview.models.Seller;
import com.sentryc.interview.SentrycInterview.repositories.SellerRepository;
import com.sentryc.interview.SentrycInterview.services.SellerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Ayushya
 */
@RestController
@RequestMapping("/sellers")
public class SellerController {

    private final SellerRepository sellerRepository;

    private final SellerService sellerService;

    public SellerController(SellerRepository sellerRepository, SellerService sellerService) {
        this.sellerRepository = sellerRepository;
        this.sellerService = sellerService;
    }


    @GetMapping
    public Page<Seller> getSellers(Pageable pageable) {
        return sellerRepository.findAll(pageable);
    }

    @GetMapping("/filter")
    public Data filterSellers(Params params, Pageable pageable) {
        return sellerService.findCustomSellerInformation(params, pageable);
    }

    @PostMapping
    public Seller createSeller(Seller seller) {
        return sellerRepository.save(seller);
    }
}
