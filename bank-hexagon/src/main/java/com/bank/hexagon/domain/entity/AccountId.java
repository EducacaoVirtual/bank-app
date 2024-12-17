package com.bank.hexagon.domain.entity;

import java.util.UUID;

public record AccountId(UUID id) {
    public AccountId {
        if (id == null) {
            throw new IllegalArgumentException("AccountId cannot be null");
        }
    }

    public AccountId() {
        this(UUID.randomUUID());
    }
}
