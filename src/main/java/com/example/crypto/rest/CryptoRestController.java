package com.example.crypto.rest;

import com.example.crypto.domain.model.Coin;
import com.example.crypto.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("coins")
public class CryptoRestController {
    @Autowired
    CoinService service;

    @GetMapping
    public Iterable<Coin> findAll() {
        return service.findAll();
    }
}
