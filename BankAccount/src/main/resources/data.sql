INSERT INTO account (account_number, balance) VALUES ('123456', 1000);
INSERT INTO account (account_number, balance) VALUES ('789012', 2000);


INSERT INTO transaction (transaction_date, operation, amount, balance, account_id) VALUES ('2023-07-01', 'Deposit', 100, 100, 1);
INSERT INTO transaction (transaction_date, operation, amount, balance, account_id) VALUES ('2023-07-02', 'Withdrawal', 50, 50, 1);

