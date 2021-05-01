package com.example.crypto.domain.repository;

import com.example.crypto.domain.model.Coin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoinRepository extends CrudRepository<Coin, Long> {
    List<Coin> findAll();
    Optional<Coin> findByName(String name);
}
