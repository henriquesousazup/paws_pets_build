CREATE TABLE servico
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    nome  VARCHAR(255),
    valor DECIMAL,
    CONSTRAINT pk_servico PRIMARY KEY (id)
);
