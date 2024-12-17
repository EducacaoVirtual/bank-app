package com.bank.h2adapter.infrastructure.repository;

import com.bank.h2adapter.infrastructure.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, UUID> {
}
