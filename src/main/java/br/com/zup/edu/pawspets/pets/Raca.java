package br.com.zup.edu.pawspets.pets;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.StringJoiner;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "raca")
public class Raca {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String nome;


    public Raca(String nome) {
        this.nome = nome;
    }

    /**
     * @deprecated para uso do hibernate apenas
     */
    @Deprecated
    public Raca() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Raca raca = (Raca) o;
        return nome.equals(raca.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Raca.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .toString();
    }
}
