package com.example.crypto.service;

import com.example.crypto.domain.model.Coin;
import com.example.crypto.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoinService {
    @Autowired
    private CoinRepository repository;

    public Coin save(Coin coin) {
        return repository.save(coin);
    }

    public List<Coin> findAll() {
        List<Coin> all = repository.findAll();
        return all; }

    public Coin processCoin(Coin coin) {
        Optional<Coin> byName = repository.findByName(coin.getName());
        if (byName.isPresent()) {
            Coin coinToUpdate = byName.get();
            coinToUpdate = coin;
            return coinToUpdate;
        }
        return repository.save(coin);
    }
}
