package com.bank.hexagon.domain.exception;

public class BankValidationException extends RuntimeException {

    public BankValidationException(String message) {
        super(message);
    }

    public static void when(boolean condition, String message) {
        if (condition) {
            throw new BankValidationException(message);
        }
    }
}
