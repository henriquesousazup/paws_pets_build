package br.com.zup.edu.pawspets.vacinacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Dose {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    private Vacina vacina;

    private LocalDateTime aplicadaEm;

    @Deprecated
    public Dose() {
    }

    public Dose(Vacina vacina, LocalDateTime aplicadaEm) {
        this.vacina = vacina;
        this.aplicadaEm = aplicadaEm;
    }

    public Long getId() {
        return id;
    }
}
