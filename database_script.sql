CREATE DATABASE postgres
    WITH OWNER = postgres
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    CONNECTION LIMIT = -1;

CREATE TABLE card
(
    id          bigint generated by default as identity,
    card_number varchar(30) NOT NULL,
    pin         varchar(4)  NOT NULL,
    attempt     int         NOT NULL,
    enable      boolean,
    money       bigint,
    primary key (id)
);

CREATE TABLE history
(
    id           bigint generated by default as identity,
    card_id      bigint REFERENCES card (id),
    operation_id bigint REFERENCES operation (id),
    date         timestamp,
    money_action bigint,
    money_remain bigint,
    primary key (id)
);

CREATE TABLE operation
(
    id        bigint generated by default as identity,
    operation varchar(255),
    primary key (id)
);


INSERT INTO public.operation(
    operation)
VALUES ('check');

INSERT INTO public.operation(
    operation)
VALUES ('put');

INSERT INTO public.operation(
    operation)
VALUES ('subtract');