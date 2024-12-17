package com.bank.api.dto;

public record AccountRequest(
    String bank,
    String branch,
    String accountNumber,
    Double balance,
    String accountHolderId,
    String limits,
    String active
) {

}
