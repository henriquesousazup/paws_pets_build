package br.com.zup.edu.pawspets.servicos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Um serviço é uma abstração para os serviços oferecidos pelo pet shop como: Banho, Tosa e vacinação
 */
@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Positive
    private BigDecimal valor;

    public Servico(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Deprecated
    public Servico() {
    }

    public Long getId() {
        return id;
    }

}
