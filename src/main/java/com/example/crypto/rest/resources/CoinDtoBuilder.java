package com.example.crypto.rest.resources;

public final class CoinDtoBuilder {
    private Long id;
    private String name;
    private String symbol;
    private double marketCap;
    private int tier;
    private double price;
    private int rank;
    private String iconUrl;

    private CoinDtoBuilder() {
    }

    public static CoinDtoBuilder coinDtoBuilder() {
        return new CoinDtoBuilder();
    }

    public CoinDtoBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CoinDtoBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CoinDtoBuilder withSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public CoinDtoBuilder withMarketCap(double marketCap) {
        this.marketCap = marketCap;
        return this;
    }

    public CoinDtoBuilder withTier(int tier) {
        this.tier = tier;
        return this;
    }

    public CoinDtoBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public CoinDtoBuilder withRank(int rank) {
        this.rank = rank;
        return this;
    }

    public CoinDtoBuilder withIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public CoinDto build() {
        CoinDto coinDto = new CoinDto();
        coinDto.setId(id);
        coinDto.setName(name);
        coinDto.setSymbol(symbol);
        coinDto.setMarketCap(marketCap);
        coinDto.setTier(tier);
        coinDto.setPrice(price);
        coinDto.setRank(rank);
        coinDto.setIconUrl(iconUrl);
        return coinDto;
    }
}
