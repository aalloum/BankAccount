package com.test.BankAccount.service;

import com.test.BankAccount.domain.Account;
import com.test.BankAccount.domain.Transaction;
import com.test.BankAccount.repository.AccountRepository;
import com.test.BankAccount.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void deposit(String accountNumber, BigDecimal amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        deposit(amount, account);
        accountRepository.save(account);
    }

    public void withdraw(String accountNumber, BigDecimal amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        withdraw(amount, account);
        accountRepository.save(account);
    }

    public List<Transaction> getTransactionHistory(String accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }

    public void deposit(BigDecimal amount, Account account) {
        validateAmount(amount);
        account.setBalance(account.getBalance().add(amount));
        recordTransaction("Deposit", amount, account);
    }

    public void withdraw(BigDecimal amount, Account account) {
        validateAmount(amount);
        if (amount.compareTo(account.getBalance()) > 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        account.setBalance(account.getBalance().subtract(amount));
        recordTransaction("Withdrawal", amount.negate(), account);
    }

    private void recordTransaction(String operation, BigDecimal amount, Account account) {
        Transaction transaction = new Transaction(LocalDate.now(), operation, amount, account.getBalance());
        transaction.setAccount(account);
        transactionRepository.save(transaction);
    }

    private void validateAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
    }
}
