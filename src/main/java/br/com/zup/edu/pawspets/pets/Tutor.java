package br.com.zup.edu.pawspets.pets;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.StringJoiner;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tutor")
public class Tutor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @CPF
    private String documento;

    @Size(min = 14, max = 14)
    @Pattern(regexp = "^\\+[1-9][0-9]\\d{1,14}")
    private String telefone;

    public Tutor(String nome,
                 String documento,
                 String telefone) {

        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
    }

    /**
     * @deprecated para uso do hibernate apenas
     */
    @Deprecated
    public Tutor() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutor tutor = (Tutor) o;
        return nome.equals(tutor.nome) && documento.equals(tutor.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, documento);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tutor.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .add("documento='" + documento + "'")
                .add("telefone='" + telefone + "'")
                .toString();
    }
}
