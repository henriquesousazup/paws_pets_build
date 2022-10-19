CREATE TABLE agendamento(
  id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  horario timestamp,
  status varchar(50),
  pet_id bigint,
  servico_id bigint,
  CONSTRAINT fk_pet_id_agendamento FOREIGN KEY (pet_id) REFERENCES pet(id),
  CONSTRAINT fk_servico_id_agendamento FOREIGN KEY (servico_id) REFERENCES servico(id)
);