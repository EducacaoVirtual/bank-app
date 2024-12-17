package com.bank.hexagon.domain.vo;

import com.bank.hexagon.domain.exception.BankValidationException;

public record Limit(
        Double dailyTransactionLimit,
        Double dailyTransferLimit,
        Double dailyWithdrawLimit
) {
    public Limit(Double dailyTransactionLimit, Double dailyTransferLimit, Double dailyWithdrawLimit) {
        validate(dailyTransactionLimit, dailyTransferLimit, dailyWithdrawLimit);
        this.dailyTransactionLimit = 0.0;
        this.dailyTransferLimit = 0.0;
        this.dailyWithdrawLimit = 0.0;
    }

    private void validate(Double dailyTransactionLimit, Double dailyTransferLimit, Double dailyWithdrawLimit) {
        StringBuilder sb = new StringBuilder();

        if (dailyTransactionLimit < 0) {
            sb.append("dailyTransactionLimit must be greater than 0");
        }

        if (dailyTransferLimit < 0) {
            sb.append("dailyTransferLimit must be greater than 0");
        }

        if (dailyWithdrawLimit < 0) {
            sb.append("dailyWithdrawLimit must be greater than 0");
        }

        BankValidationException.when(!sb.isEmpty(), sb.toString());
    }
}
