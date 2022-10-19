package br.com.zup.edu.pawspets.agendamentos;

import br.com.zup.edu.pawspets.pets.Pet;
import br.com.zup.edu.pawspets.servicos.Servico;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private LocalDateTime horario;

    @ManyToOne
    private Pet pet;

    @ManyToOne
    private Servico servico;

    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate.
     */
    @Deprecated
    public Agendamento() {
    }

    public Agendamento(LocalDateTime horario, Pet pet, Servico servico, Status status) {
        this.horario = horario;
        this.pet = pet;
        this.servico = servico;
        this.status = status;
    }

    public Long getId() {
        return id;
    }
}
