package com.bank.hexagon.infrastructure;

import com.bank.hexagon.domain.dto.AccountDTO;

import java.util.List;
import java.util.UUID;

public interface AccountRepository {
    AccountDTO save(AccountDTO accountDTO);
    AccountDTO update(AccountDTO accountDTO);
    List<AccountDTO> findAll();
    AccountDTO findAccountById(UUID id);
    void transfer(UUID from, UUID to, Double amount);
    void credit(UUID id, Double amount);
    void debit(UUID id, Double amount);
    Double getBalance(UUID id);
}
