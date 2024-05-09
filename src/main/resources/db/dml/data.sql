insert into currencies(title, money_sign)
VALUES ('US Dollar', 'USD'),
       ('Russian ruble', 'RUB'),
       ('Belarusian ruble', 'BYN');

insert into exchange_rates(rate, initial_amount, concluding_amount, initial_id, concluding_id)
VALUES (1.23003, 1, 1, 1, 2),
       (1.18, 1, 1, 2, 1);
