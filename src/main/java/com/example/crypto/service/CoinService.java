package com.example.crypto.service;

import com.example.crypto.domain.exceptions.CoinNotFoundException;
import com.example.crypto.domain.mapper.CoinMapper;
import com.example.crypto.domain.model.Coin;
import com.example.crypto.repository.CoinRepository;
import com.example.crypto.rest.resources.CoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class CoinService {
    @Autowired
    private CoinRepository repository;
    @Autowired
    private CoinMapper mapper;

    public Coin save(Coin coin) {
        return repository.save(coin);
    }

    public List<CoinDto> findAll() {
        return repository.findAll()
                .stream().map(coin -> mapper.toDto(coin))
                .collect(toList());
    }

    public Coin processCoin(CoinDto coin) {
        Optional<Coin> byName = repository.findByName(coin.getName());
        if (byName.isPresent()) {
            Coin model = mapper.toModel(coin);
            Coin toUpdate = byName.get();
            toUpdate.setName(model.getName());
            toUpdate.setIconUrl(model.getIconUrl());
            toUpdate.setPrice(model.getPrice());
            toUpdate.setRank(model.getRank());
            toUpdate.setSymbol(model.getSymbol());
            toUpdate.setMarketCap(model.getMarketCap());
            toUpdate.setTier(model.getTier());
            return toUpdate;
        }
        return repository.save(mapper.toModel(coin));
    }

    public CoinDto findById(long id) {
        return repository.findById(id)
                .map(coin -> mapper.toDto(coin))
                .orElseThrow(() -> new CoinNotFoundException("Coin with id: " + id + " not found."));
    }
}
