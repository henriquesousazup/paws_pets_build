package br.com.zup.edu.pawspets.vacinacao;

import br.com.zup.edu.pawspets.pets.Pet;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class CarteiraDeVacinacao {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne
    private Pet pet;

    @ManyToMany
    private List<Dose> doses;

    @Deprecated
    public CarteiraDeVacinacao() {
    }

    public CarteiraDeVacinacao(Pet pet, List<Dose> doses) {
        this.pet = pet;
        this.doses = doses;
    }

    public Long getId() {
        return id;
    }
}
