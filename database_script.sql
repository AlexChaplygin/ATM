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
    id             SERIAL                 NOT NULL PRIMARY KEY,
    number         character varying(16)  NOT NULL,
    is_blocked     boolean DEFAULT FALSE,
    pin            character varying(250) NOT NULL,
    wrong_attempts integer DEFAULT 0,
    money          BIGINT  DEFAULT 0
)
    WITH (
        OIDS = FALSE
    );
ALTER TABLE public."card"
    OWNER TO postgres;


-- Table: public.operation

-- DROP TABLE public.operation;

CREATE TABLE public.operation
(
    id             SERIAL                NOT NULL PRIMARY KEY,
    card_id        integer               NOT NULL REFERENCES public.card (id),
    date           date                  NOT NULL,
    card_operation character varying(10) NOT NULL,
    withdrawal     BIGINT
)
    WITH (
        OIDS = FALSE
    );
ALTER TABLE public.operation
    OWNER TO postgres;

-- 1111 pin
INSERT INTO card(number, is_blocked, pin, wrong_attempts, money)
VALUES (1234123412341234, FALSE, '$2a$10$Xyt.DYjlvEUpz4vuDSzzjeyxAjf8RbEMHo77Rwwsn.gaKpRnqJ.3G', 0, 1000);