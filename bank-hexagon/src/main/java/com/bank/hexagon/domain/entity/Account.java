package com.bank.hexagon.domain.entity;


import com.bank.hexagon.domain.exception.BankValidationException;
import com.bank.hexagon.domain.vo.Limit;

public class Account {
    private AccountId accountId;
    private final String bank;
    private final String branch;
    private final String accountNumber;
    private Double balance = 0.0;
    private final AccountHolderId accountHolderId;
    private Limit limits;
    private boolean active;

    public Account(String bank, String branch, String accountNumber, Double balance, AccountHolderId accountHolderId, Limit limits, boolean active) {
        validate(bank, branch, accountNumber, balance, accountHolderId, limits);
        this.bank = bank;
        this.branch = branch;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderId = accountHolderId;
        this.limits = limits;
        this.active = active;
    }

    private void validate(String bank, String branch, String accountNumber, Double balance, AccountHolderId accountHolderId, Limit limit) {
        StringBuilder sb = new StringBuilder();

        final int ACCOUNT_NUMBER_LENGTH = 8;
        final int BRANCH_NUMBER_LENGTH = 5;
        final int BANK_NUMBER_LENGTH = 3;

        if (bank.length() != BANK_NUMBER_LENGTH) {
            sb.append("bank must be " + BANK_NUMBER_LENGTH + " characters long");
        }

        if (branch.length() != BRANCH_NUMBER_LENGTH) {
            sb.append("branch must be " + BRANCH_NUMBER_LENGTH + " characters long");
        }

        if (accountNumber.length() != ACCOUNT_NUMBER_LENGTH) {
            sb.append("accountNumber must be " + ACCOUNT_NUMBER_LENGTH + " characters long");
        }

        if (balance < 0) {
            sb.append("balance must be greater than 0");
        }

        if (accountHolderId == null) {
            sb.append("accountHolderId cannot be null");
        }

        if (limits == null) {
            sb.append("limit cannot be null");
        }

        BankValidationException.when(!sb.isEmpty(), sb.toString());
    }

    public void credit(Double amount) {
        this.balance += amount;
    }

    public void debit(Double amount) {
        this.balance -= amount;
    }

    public void transfer(Account account, Double amount) {
        this.balance -= amount;
        account.balance += amount;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setLimit(Limit limits) {
        this.limits = limits;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public String getBank() {
        return bank;
    }

    public String getBranch() {
        return branch;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public AccountHolderId getAccountHolderId() {
        return accountHolderId;
    }

    public Limit getLimits() {
        return limits;
    }

    public boolean isActive() {
        return active;
    }
}
