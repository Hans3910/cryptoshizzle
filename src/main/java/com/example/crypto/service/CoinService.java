package com.example.crypto.service;

import com.example.crypto.domain.model.Coin;
import com.example.crypto.domain.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoinService {
    @Autowired
    private CoinRepository repository;

    public Coin save(Coin coin) {
        return repository.save(coin);
    }

    public Iterable<Coin> findAll() { return repository.findAll(); }
}
