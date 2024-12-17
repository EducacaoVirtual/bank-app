package com.bank.hexagon.domain.mapper;

import com.bank.hexagon.domain.dto.AccountDTO;
import com.bank.hexagon.domain.entity.Account;
import com.bank.hexagon.domain.entity.AccountHolderId;
import com.bank.hexagon.domain.vo.Limit;

public class AccountMapper {
    public AccountDTO toDTO(Account account) {
        return new AccountDTO(
                account.getAccountId().id(),
                account.getBank(),
                account.getBranch(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getAccountHolderId().id(),
                account.getLimits().toString(),
                account.isActive()
        );
    }

    public Account toEntity(AccountDTO accountDTO) {
        return new Account(
                accountDTO.bank(),
                accountDTO.branch(),
                accountDTO.accountNumber(),
                accountDTO.balance(),
                new AccountHolderId(accountDTO.accountHolderId()),
                toLimit(accountDTO.limits()),
                accountDTO.active()
        );
    }

    private Limit toLimit(String limit) {
        String[] limits = limit.split(",");

        if (limits.length != 3) {
            throw new IllegalArgumentException("Invalid limit format");
        }

        return new Limit(
                Double.parseDouble(limits[0]),
                Double.parseDouble(limits[1]),
                Double.parseDouble(limits[2]));
    }
}
