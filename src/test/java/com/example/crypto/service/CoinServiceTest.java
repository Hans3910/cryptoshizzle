package com.example.crypto.service;

import com.example.crypto.domain.exceptions.CoinNotFoundException;
import com.example.crypto.domain.mapper.CoinMapper;
import com.example.crypto.domain.model.Coin;
import com.example.crypto.domain.model.CoinBuilder;
import com.example.crypto.repository.CoinRepository;
import com.example.crypto.rest.resources.CoinDto;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.crypto.domain.model.CoinBuilder.coinBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CoinServiceTest {
    private Coin coin;
    @Mock
    private CoinRepository repository;

    @Mock
    private CoinMapper mapper;

    @InjectMocks
    private CoinService service;

    @Before
    public void setup() throws Exception {
        coin = create();
        MockitoAnnotations.openMocks(service);
        when(repository.findAll()).thenReturn(Collections.singletonList(coin));
        when(mapper.toDto(any(Coin.class))).thenCallRealMethod();
    }

    @Test
    public void findAllReturnsAllCoins() {
        List<CoinDto> coins = service.findAll();
        assertEquals(1, coins.size());
        assertThat(coins.get(0)).extracting("name").isEqualTo("crypto test");
        verify(mapper, times(1)).toDto(any(Coin.class));
    }

    @Test
    public void throwsCoinNotFoundExceptionWhenIdNotFound() {
        assertThrows(CoinNotFoundException.class, () -> service.findById(1L));
    }

    @Test(expected = CoinNotFoundException.class)
    public void throwsCoinNotFoundException() {
        service.findById(1L);
    }

    private static Coin create() {
        return coinBuilder()
                .withIconUrl("iconUrl")
                .withMarketCap(2.5)
                .withName("crypto test")
                .withPrice(1500)
                .withRank(1)
                .withSymbol("symbol")
                .withTier(1)
                .build();
    }
}