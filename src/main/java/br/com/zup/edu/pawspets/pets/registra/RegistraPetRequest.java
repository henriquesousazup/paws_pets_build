package br.com.zup.edu.pawspets.pets.registra;

import br.com.zup.edu.pawspets.pets.Pet;
import br.com.zup.edu.pawspets.pets.RacaRepository;
import br.com.zup.edu.pawspets.pets.Sexo;
import br.com.zup.edu.pawspets.pets.TutorRepository;

import javax.validation.constraints.*;

public class RegistraPetRequest {

    @NotBlank
    private String nome;

    @NotNull
    @Min(1)
    private Long raca;

    @PositiveOrZero
    private int idade;

    @NotNull
    @Min(1)
    private Long tutor;

    @Pattern(regexp = "(^MACHO$|^FEMEA$)")
    private String sexo;

    /**
     * @deprecated para uso dos frameworks
     */
    @Deprecated
    public RegistraPetRequest() {
    }

    public RegistraPetRequest(String nome,
                              Long raca,
                              int idade,
                              Long tutor,
                              String sexo) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.tutor = tutor;
        this.sexo = sexo;
    }

    public Pet toModel(TutorRepository tutorRepository,
                       RacaRepository racaRepository) {

        var tutor = tutorRepository.findById(this.tutor)
                .orElseThrow(() -> new IllegalStateException("tutor nao encontrado"));

        var raca = racaRepository.findById(this.raca)
                .orElseThrow(() -> new IllegalStateException("tutor nao encontrado"));

        return new Pet(nome, raca, idade, tutor, Sexo.valueOf(sexo));

    }

}
