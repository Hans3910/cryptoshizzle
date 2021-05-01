package com.example.crypto.rest;

import com.example.crypto.domain.model.Coin;
import com.example.crypto.request.HttpUrlConnection;
import com.example.crypto.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("coins")
public class CryptoRestController {
    @Autowired
    CoinService service;

    @Autowired
    HttpUrlConnection connection;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Coin> findAll() {
        List<Coin> all = service.findAll();
        return all;
    }

    @CrossOrigin
    @PostMapping("/update")
    public void update() throws IOException {
        connection.init();
    }
}
