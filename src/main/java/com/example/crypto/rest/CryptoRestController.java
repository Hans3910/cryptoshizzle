package com.example.crypto.rest;

import com.example.crypto.domain.model.Coin;
import com.example.crypto.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coins")
public class CryptoRestController {
    @Autowired
    CoinService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Coin> findAll() {
        List<Coin> all = service.findAll();
        return all;
    }
}
