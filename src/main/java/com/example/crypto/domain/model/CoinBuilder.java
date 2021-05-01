package com.example.crypto.domain.model;

public final class CoinBuilder {
    private String symbol;
    private double marketCap;
    private int tier;
    private double price;
    private String name;
    private int rank;
    private String iconUrl;

    private CoinBuilder() {
    }

    public static CoinBuilder coinBuilder() {
        return new CoinBuilder();
    }

    public CoinBuilder withSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public CoinBuilder withMarketCap(double marketCap) {
        this.marketCap = marketCap;
        return this;
    }

    public CoinBuilder withTier(int tier) {
        this.tier = tier;
        return this;
    }

    public CoinBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public CoinBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CoinBuilder withRank(int rank) {
        this.rank = rank;
        return this;
    }

    public CoinBuilder withIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public Coin build() {
        return new Coin(symbol, marketCap, tier, price, name, rank, iconUrl);
    }
}
