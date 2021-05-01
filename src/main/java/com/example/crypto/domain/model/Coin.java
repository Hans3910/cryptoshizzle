package com.example.crypto.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "coins")
public class Coin {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String symbol;
    @Column(name = "marketCap", length = 100)
    private double marketCap;
    private int tier;
    private double price;
    private int rank;
    @Column(name = "iconUrl", length = 100)
    private String iconUrl;

    public Coin() {
    }

    public Coin(String symbol, double marketCap, int tier, double price, String name, int rank, String iconUrl) {
        this.symbol = symbol;
        this.marketCap = marketCap;
        this.tier = tier;
        this.price = price;
        this.name = name;
        this.rank = rank;
        this.iconUrl = iconUrl;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return Objects.equals(symbol, coin.symbol) && Objects.equals(name, coin.name) && Objects.equals(iconUrl, coin.iconUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, name, iconUrl);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
