package com.example.crypto.domain.exceptions;

public class CoinNotFoundException extends RuntimeException {
    public CoinNotFoundException(String message) {
        super(message);
    }
}
