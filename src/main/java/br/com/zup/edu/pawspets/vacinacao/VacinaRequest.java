package br.com.zup.edu.pawspets.vacinacao;

import javax.validation.constraints.NotBlank;

public class VacinaRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String marca;

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }


    public Vacina toVacina() {
        return new Vacina(nome, marca);
    }
}
