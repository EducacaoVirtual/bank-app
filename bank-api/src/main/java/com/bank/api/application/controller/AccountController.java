package com.bank.api.application.controller;

import com.bank.api.service.AccountApiService;
import com.bank.hexagon.domain.dto.AccountDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountApiService accountApiService;

    public AccountController(AccountApiService accountApiService) {
        this.accountApiService = accountApiService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(accountApiService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findAccountById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(accountApiService.findAccountById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.ok(accountApiService.save(accountDTO));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.ok(accountApiService.update(accountDTO));
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestParam(name = "from") UUID from, @RequestParam(name = "to") UUID to, @RequestParam(name = "amount") Double amount) {
        accountApiService.transfer(from, to, amount);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/credit")
    public ResponseEntity<?> credit(@RequestParam(name = "id") UUID id, @RequestParam(name = "amount") Double amount) {
        accountApiService.credit(id, amount);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/debit")
    public ResponseEntity<?> debit(@RequestParam(name = "id") UUID id, @RequestParam(name = "amount") Double amount) {
        accountApiService.debit(id, amount);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/balance")
    public ResponseEntity<?> getBalance(@RequestParam(name = "id") UUID id) {
        return ResponseEntity.ok(accountApiService.getBalance(id));
    }
}
