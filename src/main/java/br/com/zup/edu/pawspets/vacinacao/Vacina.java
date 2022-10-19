package br.com.zup.edu.pawspets.vacinacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Vacina {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String marca;

    public Vacina() {
    }

    public Vacina(String nome, String marca) {
        this.nome = nome;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }
}
