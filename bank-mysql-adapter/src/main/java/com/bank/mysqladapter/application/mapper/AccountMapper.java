package com.bank.mysqladapter.application.mapper;

import com.bank.hexagon.domain.dto.AccountDTO;
import com.bank.mysqladapter.infrastructure.entity.AccountEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountEntity toEntity(AccountDTO accountDTO) {
        AccountEntity entity = new AccountEntity();
        BeanUtils.copyProperties(accountDTO, entity);
        return entity;
    }

    public AccountDTO toDTO(AccountEntity entity) {
        return new AccountDTO(
                entity.getAccountId(),
                entity.getBank(),
                entity.getBranch(),
                entity.getAccountNumber(),
                entity.getBalance(),
                entity.getAccountHolderId(),
                entity.getLimits(),
                entity.getActive()
        );
    }
}
