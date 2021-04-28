package com.example.crypto.repository;

import com.example.crypto.domain.model.Coin;
import com.example.crypto.domain.model.CoinBuilder;
import com.example.crypto.domain.repository.CoinRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repository.class))
class CoinRepositoryTest {
    @Autowired
    private CoinRepository repository;

    @Test
    void canSave() {
        Coin coin = CoinBuilder.aCoin()
                .withName("name")
                .withMarketCap(1.2)
                .withPrice(12.5)
                .withRank(1)
                .withSymbol("XRP")
                .build();
        Coin result = repository.save(coin);
        Optional<Coin> byId = repository.findById(result.getId());
        assertTrue(byId.isPresent());
        assertEquals(result.getId(), byId.get().getId());
    }
}