-- Database: atm

-- DROP DATABASE atm;

CREATE DATABASE atm
    WITH OWNER = postgres
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    CONNECTION LIMIT = -1;


-- Table: public."card"

-- DROP TABLE public."card";

CREATE TABLE public."card"
(
    id             SERIAL  NOT NULL PRIMARY KEY,
    number         character varying(16) NOT NULL,
    is_blocked     boolean DEFAULT FALSE,
    pin            character varying(4) NOT NULL,
    wrong_attempts integer DEFAULT 0,
    money          BIGINT DEFAULT 0
)
    WITH (
        OIDS = FALSE
    );
ALTER TABLE public."card"
    OWNER TO postgres;


-- Table: public.card_operation

-- DROP TABLE public.card_operation;

CREATE TABLE public.card_operation
(
    id             SERIAL                NOT NULL PRIMARY KEY,
    operation_name character varying(50) NOT NULL
)
    WITH (
        OIDS = FALSE
    );
ALTER TABLE public.card_operation
    OWNER TO postgres;


-- Table: public.operation

-- DROP TABLE public.operation;

CREATE TABLE public.operation
(
    id                SERIAL  NOT NULL PRIMARY KEY,
    card_id           integer NOT NULL REFERENCES public.card (id),
    date              date    NOT NULL,
    code_operation_id integer NOT NULL REFERENCES public.card_operation (id),
    withdrawal        BIGINT NOT NULL
)
    WITH (
        OIDS = FALSE
    );
ALTER TABLE public.operation
    OWNER TO postgres;


INSERT INTO card(number,is_blocked,pin,wrong_attempts,money) VALUES(1234123412341234,FALSE,1111,0,1000);
INSERT INTO card(number,is_blocked,pin,wrong_attempts,money) VALUES(5656565656565656,FALSE,2222,0,123123);
INSERT INTO card(number,is_blocked,pin,wrong_attempts,money) VALUES(7878787878787878,FALSE,3333,0,1033300);
INSERT INTO card(number,is_blocked,pin,wrong_attempts,money) VALUES(9898989898989898,FALSE,4444,0,100123130);

INSERT INTO card_operation(operation_name) VALUES('Баланс');
INSERT INTO card_operation(operation_name) VALUES('Снятие денег');

