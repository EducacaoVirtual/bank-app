package com.bank.h2adapter.application.service;

import com.bank.h2adapter.application.mapper.AccountMapper;
import com.bank.h2adapter.infrastructure.entity.AccountEntity;
import com.bank.h2adapter.infrastructure.repository.AccountJpaRepository;
import com.bank.hexagon.domain.dto.AccountDTO;
import com.bank.hexagon.port.driven.AccountDrivenPort;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("h2")
public class AccountInMemoryService implements AccountDrivenPort {
    private final AccountJpaRepository accountJpaRepository;
    private final AccountMapper mapper;

    public AccountInMemoryService(AccountJpaRepository accountJpaRepository, AccountMapper mapper) {
        this.accountJpaRepository = accountJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        AccountEntity entity = mapper.toEntity(accountDTO);
        return mapper.toDTO(accountJpaRepository.save(entity));
    }

    @Override
    public AccountDTO update(AccountDTO accountDTO) {
        accountJpaRepository.findById(accountDTO.accountId())
                .ifPresentOrElse(entity -> {
                    BeanUtils.copyProperties(accountDTO, entity);
                    accountJpaRepository.save(entity);
                }, () -> {
                    throw new IllegalArgumentException("Account not found");
                });
        return accountDTO;
    }

    @Override
    public List<AccountDTO> findAll() {
        return accountJpaRepository
                .findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public AccountDTO findAccountById(UUID id) {
        Optional<AccountEntity> account = accountJpaRepository.findById(id);
        if (account.isPresent()) {
            return mapper.toDTO(account.get());
        }
        throw new IllegalArgumentException("Account not found");
    }

    @Override
    @Transactional
    public void transfer(UUID from, UUID to, Double amount) {
        accountJpaRepository
                .findById(from)
                .ifPresentOrElse(entity -> {
                    entity.setBalance(entity.getBalance() - amount);
                    accountJpaRepository.save(entity);
                }, () -> {
                    throw new IllegalArgumentException("Account not found");
                });

        accountJpaRepository
                .findById(to)
                .ifPresentOrElse(entity -> {
                    entity.setBalance(entity.getBalance() + amount);
                    accountJpaRepository.save(entity);
                }, () -> {
                    throw new IllegalArgumentException("Account not found");
                });
    }

    @Override
    public void credit(UUID id, Double amount) {
        accountJpaRepository
                .findById(id)
                .ifPresentOrElse(entity -> {
                    entity.setBalance(entity.getBalance() + amount);
                    accountJpaRepository.save(entity);
                }, () -> {
                    throw new IllegalArgumentException("Does not possible credit to this account, account not found");
                });
    }

    @Override
    public void debit(UUID id, Double amount) {
        accountJpaRepository
                .findById(id)
                .ifPresentOrElse(entity -> {
                    entity.setBalance(entity.getBalance() - amount);
                    accountJpaRepository.save(entity);
                }, () -> {
                    throw new IllegalArgumentException("Does not possible debit to this account, account not found");
                });
    }

    @Override
    public Double getBalance(UUID id) {
        return accountJpaRepository
                .findById(id)
                .map(AccountEntity::getBalance)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }
}
