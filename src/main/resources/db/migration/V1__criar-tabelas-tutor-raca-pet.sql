CREATE TABLE tutor
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    nome      VARCHAR(120),
    documento VARCHAR(11),
    telefone  VARCHAR(14),
    CONSTRAINT pk_tutor PRIMARY KEY (id)
);

CREATE TABLE raca
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(120),
    CONSTRAINT pk_raca PRIMARY KEY (id)
);

CREATE TABLE pet
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    nome       VARCHAR(120),
    raca_id    BIGINT,
    nascimento date,
    tutor_id   BIGINT,
    sexo       VARCHAR(15),
    CONSTRAINT pk_pet PRIMARY KEY (id)
);

ALTER TABLE pet
    ADD CONSTRAINT FK_PET_ON_RACA FOREIGN KEY (raca_id) REFERENCES raca (id);

ALTER TABLE pet
    ADD CONSTRAINT FK_PET_ON_TUTOR FOREIGN KEY (tutor_id) REFERENCES tutor (id);