package br.com.zup.edu.pawspets.pets.consulta;

import br.com.zup.edu.pawspets.pets.Pet;

import java.time.LocalDate;
import java.util.StringJoiner;

public class PetResponse {

    private String nome;
    private RacaResponse raca;
    private LocalDate nascimento;
    private TutorResponse tutor;
    private String sexo;

    public PetResponse(Pet pet) {

        this.nome = pet.getNome();
        this.raca = new RacaResponse(pet.getRaca());
        this.nascimento = pet.getNascimento();
        this.tutor = new TutorResponse(pet.getTutor());
        this.sexo = pet.getSexo().name();

    }

    /**
     * @deprecated para uso dos frameworks
     */
    @Deprecated
    public PetResponse() {
    }

    public String getNome() {
        return nome;
    }

    public RacaResponse getRaca() {
        return raca;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public TutorResponse getTutor() {
        return tutor;
    }

    public String getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PetResponse.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .add("raca=" + raca)
                .add("nascimento=" + nascimento)
                .add("tutor=" + tutor)
                .add("sexo='" + sexo + "'")
                .toString();
    }
}
