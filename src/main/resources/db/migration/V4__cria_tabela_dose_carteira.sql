create table dose(
    id bigint not null auto_increment,
    aplicada_em timestamp,
    vacina_id bigint,
    constraint pk_dose PRIMARY KEY (id),
    constraint fk_vacina_id FOREIGN KEY (vacina_id) references vacina(id)
);

create table carteira_de_vacinacao(
    id bigint not null auto_increment,
    pet_id bigint not null,
    constraint pk_carteira PRIMARY KEY (id),
    constraint fk_pet_id FOREIGN KEY (pet_id) references pet(id)
);

create table carteira_de_vacinacao_doses(
    carteira_de_vacinacao_id bigint not null,
    doses_id bigint not null,
    constraint pk_dose_id_carteira_de_vacinacao_id primary key (carteira_de_vacinacao_id, doses_id),
    constraint fk_carteira_de_vacinacao_doses_carteira_id FOREIGN KEY (carteira_de_vacinacao_id) references carteira_de_vacinacao(id),
    constraint fk_carteira_de_vacinacao_doses_dose_id FOREIGN KEY (doses_id) references dose(id)
);
