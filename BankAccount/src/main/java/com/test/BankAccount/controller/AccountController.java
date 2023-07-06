package com.test.BankAccount.controller;

import com.test.BankAccount.domain.Transaction;
import com.test.BankAccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/{accountNumber}/deposit")
    public void deposit(@PathVariable String accountNumber, @RequestBody BigDecimal amount) {
        accountService.deposit(accountNumber, amount);
    }

    @PostMapping("/{accountNumber}/withdraw")
    public void withdraw(@PathVariable String accountNumber, @RequestBody BigDecimal amount) {
        accountService.withdraw(accountNumber, amount);
    }

    @GetMapping("/{accountNumber}/statement")
    public List<Transaction> getStatement(@PathVariable String accountNumber) {
        return accountService.getTransactionHistory(accountNumber);
    }
}


