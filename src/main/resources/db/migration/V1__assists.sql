create table assistances
(
    id          bigint auto_increment
        primary key,
    description varchar(300) not null,
    name        varchar(100) not null
);

INSERT INTO assistances (name, description) VALUES ('Troca de aparelho', 'Troca de aparelho decodificador de sinal');
INSERT INTO assistances (name, description) VALUES ('Troca de cabo interno', 'Troca de cabo interno');
INSERT INTO assistances (name, description) VALUES ('Troca de fiação interna', 'Troca de fiação interna');