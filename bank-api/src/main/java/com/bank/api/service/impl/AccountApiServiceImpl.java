package com.bank.api.service.impl;

import com.bank.api.service.AccountApiService;
import com.bank.hexagon.domain.dto.AccountDTO;
import com.bank.hexagon.port.driver.AccountDriverPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountApiServiceImpl implements AccountApiService {

    private final AccountDriverPort accountDriverPort;

    public AccountApiServiceImpl(AccountDriverPort accountDriverPort) {
        this.accountDriverPort = accountDriverPort;
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        return accountDriverPort.save(accountDTO);
    }

    @Override
    public AccountDTO update(AccountDTO accountDTO) {
        return accountDriverPort.update(accountDTO);
    }

    @Override
    public List<AccountDTO> findAll() {
        return accountDriverPort.findAll();
    }

    @Override
    public AccountDTO findAccountById(UUID id) {
        return accountDriverPort.findAccountById(id);
    }

    @Override
    public void transfer(UUID from, UUID to, Double amount) {
        accountDriverPort.transfer(from, to, amount);
    }

    @Override
    public void credit(UUID id, Double amount) {
        accountDriverPort.credit(id, amount);
    }

    @Override
    public void debit(UUID id, Double amount) {
        accountDriverPort.debit(id, amount);
    }

    @Override
    public Double getBalance(UUID id) {
        return accountDriverPort.getBalance(id);
    }
}
