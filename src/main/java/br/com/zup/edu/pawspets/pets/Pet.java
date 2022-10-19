package br.com.zup.edu.pawspets.pets;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

import static java.time.LocalDate.now;
import static java.time.temporal.ChronoUnit.YEARS;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "pet")
public class Pet {

    @NotBlank
    private String nome;

    @ManyToOne
    private Raca raca;

    @PastOrPresent
    private LocalDate nascimento;
    @ManyToOne
    private Tutor tutor;

    @Enumerated(STRING)
    private Sexo sexo;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    public Pet(String nome,
               Raca raca,
               int idade,
               Tutor tutor,
               Sexo sexo) {

        this.nome = nome;
        this.raca = raca;
        this.nascimento = now().minus(idade, YEARS);
        this.tutor = tutor;
        this.sexo = sexo;
    }

    /**
     * @deprecated para uso exclusivo do hibernate
     */
    @Deprecated
    public Pet() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Raca getRaca() {
        return raca;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Sexo getSexo() {
        return sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return nome.equals(pet.nome) && raca.equals(pet.raca) && tutor.equals(pet.tutor) && sexo == pet.sexo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, raca, tutor, sexo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pet.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .add("raca=" + raca)
                .add("nascimento=" + nascimento)
                .add("tutor=" + tutor)
                .add("sexo=" + sexo)
                .add("id=" + id)
                .toString();
    }
}
