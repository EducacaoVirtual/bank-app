package com.bank.h2adapter.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    private UUID accountId;
    @NotNull(message = "bank must not be null")
    private String bank;
    @NotNull(message = "branch must not be null")
    private String branch;
    @NotNull(message = "account number must not be null")
    private String accountNumber;
    private Double balance;
    @NotNull(message = "account holder id must not be null")
    @Column(name = "account_holder_id")
    private UUID accountHolderId;
    @NotNull(message = "limits must not be null")
    private String limits;
    @Column(name = "is_active", nullable = false)
    private boolean active = true;
}
