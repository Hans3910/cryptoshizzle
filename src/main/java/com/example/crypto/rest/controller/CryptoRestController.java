package com.example.crypto.rest.controller;

import com.example.crypto.domain.model.Coin;
import com.example.crypto.rest.request.HttpUrlConnection;
import com.example.crypto.rest.resources.CoinDto;
import com.example.crypto.service.CoinService;
import net.minidev.json.parser.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("coins")
public class CryptoRestController {
    private static final Logger LOGGER = LogManager.getLogger(CryptoRestController.class);

    @Autowired
    CoinService service;

    @GetMapping
    public List<CoinDto> findAll() {
        LOGGER.info("Retrieving all coins");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CoinDto findById(@PathVariable long id) {
        return service.findById(id);
    }
}
