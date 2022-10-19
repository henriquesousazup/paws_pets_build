package br.com.zup.edu.pawspets.pets.registra;

import br.com.zup.edu.pawspets.pets.Tutor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

public class RegistraTutorRequest {

    @NotBlank
    private String nome;

    @CPF
    @NotBlank
    private String documento;

    @NotBlank
    private String telefone;

    /**
     * @deprecated para uso dos frameworks
     */
    @Deprecated
    public RegistraTutorRequest() {
    }

    public RegistraTutorRequest(String nome,
                                String documento,
                                String telefone) {
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
    }


    public Tutor toModel() {

        return new Tutor(nome, documento, telefone);
    }
}
