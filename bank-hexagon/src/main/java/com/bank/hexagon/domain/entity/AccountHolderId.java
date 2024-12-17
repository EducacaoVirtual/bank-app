package com.bank.hexagon.domain.entity;

import java.util.UUID;

public record AccountHolderId(UUID id) {
    public AccountHolderId {
        if (id == null) {
            throw new IllegalArgumentException("AccountHolderId cannot be null");
        }
    }

    public AccountHolderId() {
        this(UUID.randomUUID());
    }
}
