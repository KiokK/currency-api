drop table if exists currencies cascade;
drop table if exists exchange_rates cascade;

CREATE TABLE currencies
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(30) NOT NULL,
    money_sign  VARCHAR(10) NOT NULL UNIQUE,
    created_at  TIMESTAMP   NOT NULL DEFAULT now(),
    modified_at TIMESTAMP   NOT NULL DEFAULT now()
);

CREATE TABLE exchange_rates
(
    id                BIGSERIAL PRIMARY KEY,
    rate              NUMERIC(8, 5) NOT NULL,
    initial_amount    SMALLINT      NOT NULL check (initial_amount > 0),
    concluding_amount SMALLINT      NOT NULL check (concluding_amount > 0),
    initial_id        BIGINT        NOT NULL REFERENCES currencies (id),
    concluding_id     BIGINT        NOT NULL REFERENCES currencies (id) check (concluding_id != initial_id),
    created_at        TIMESTAMP     NOT NULL DEFAULT now(),
    modified_at       TIMESTAMP     NOT NULL DEFAULT now()
);
