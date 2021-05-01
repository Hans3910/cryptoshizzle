package com.example.crypto.rest.controller;

import com.example.crypto.domain.model.Coin;
import com.example.crypto.rest.request.HttpUrlConnection;
import com.example.crypto.rest.resources.CoinDto;
import com.example.crypto.service.CoinService;
import net.minidev.json.parser.ParseException;
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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<CoinDto> findAll() {
        return service.findAll();
    }

    @CrossOrigin
    @PostMapping("/update")
    public void update() throws IOException, ParseException {
        connection.init();
    }
}
