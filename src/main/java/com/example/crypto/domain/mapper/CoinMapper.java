package com.example.crypto.domain.mapper;

import com.example.crypto.domain.model.Coin;
import com.example.crypto.domain.model.CoinBuilder;
import com.example.crypto.rest.resources.CoinDto;
import com.example.crypto.rest.resources.CoinDtoBuilder;
import org.springframework.stereotype.Component;

import static com.example.crypto.domain.model.CoinBuilder.coinBuilder;
import static com.example.crypto.rest.resources.CoinDtoBuilder.coinDtoBuilder;

@Component
public class CoinMapper {
    public Coin toModel(CoinDto dto) {
        return coinBuilder()
                .withName(dto.getName())
                .withIconUrl(dto.getIconUrl())
                .withMarketCap(dto.getMarketCap())
                .withPrice(dto.getPrice())
                .withRank(dto.getRank())
                .withSymbol(dto.getSymbol())
                .withTier(dto.getTier())
                .build();
    }

    public CoinDto toDto(Coin model) {
        return coinDtoBuilder()
                .withName(model.getName())
                .withIconUrl(model.getIconUrl())
                .withMarketCap(model.getMarketCap())
                .withPrice(model.getPrice())
                .withRank(model.getRank())
                .withSymbol(model.getSymbol())
                .withTier(model.getTier())
                .withId(model.getId())
                .build();
    }
}
