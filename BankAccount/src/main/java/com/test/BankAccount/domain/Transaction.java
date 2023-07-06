package com.test.BankAccount.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate transaction_date;
    private String operation;
    private BigDecimal amount;
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "account_id", nullable = true)
    private Account account;

    public Transaction(LocalDate transaction_date, String operation, BigDecimal amount, BigDecimal balance) {
        this.transaction_date = transaction_date;
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }
}

