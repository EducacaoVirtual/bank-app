package com.bank.hexagon.infrastructure.repository;

import com.bank.hexagon.domain.dto.AccountDTO;
import com.bank.hexagon.infrastructure.AccountRepository;
import com.bank.hexagon.port.driven.AccountDrivenPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    private final AccountDrivenPort accountDrivenPort;

    public AccountRepositoryImpl(AccountDrivenPort accountDrivenPort) {
        this.accountDrivenPort = accountDrivenPort;
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        return accountDrivenPort.save(accountDTO);
    }

    @Override
    public AccountDTO update(AccountDTO accountDTO) {
        AccountDTO account = accountDrivenPort.findAccountById(accountDTO.accountId());
        if (account != null) {
            return accountDrivenPort.update(accountDTO);
        }
        throw new IllegalArgumentException("Account not found");
    }

    @Override
    public List<AccountDTO> findAll() {
        return accountDrivenPort.findAll();
    }

    @Override
    public AccountDTO findAccountById(UUID id) {
        AccountDTO account = accountDrivenPort.findAccountById(id);
        if (account != null) {
            return account;
        }
        throw new IllegalArgumentException("Account not found");
    }

    @Override
    public void transfer(UUID from, UUID to, Double amount) {
        accountDrivenPort.transfer(from, to, amount);
    }

    @Override
    public void credit(UUID id, Double amount) {
        accountDrivenPort.credit(id, amount);
    }

    @Override
    public void debit(UUID id, Double amount) {
        accountDrivenPort.debit(id, amount);
    }

    @Override
    public Double getBalance(UUID id) {
        return accountDrivenPort.getBalance(id);
    }
}
