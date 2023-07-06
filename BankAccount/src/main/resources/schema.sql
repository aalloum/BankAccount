CREATE TABLE account (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         account_number VARCHAR(255),
                         balance DECIMAL(10, 2)
);

CREATE TABLE transaction (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         transaction_date date,
                         operation VARCHAR(255),
                         amount DECIMAL(10, 2),
                         balance DECIMAL(10, 2),
                         account_id BIGINT
);

