package br.com.zup.edu.pawspets.pets.registra;

import br.com.zup.edu.pawspets.pets.Raca;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class RegistraRacaRequest {

    @NotBlank
    private String nome;


    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public RegistraRacaRequest(String nome) {
        this.nome = nome;
    }

    public Raca toModel() {
        return new Raca(nome);
    }

}
