package br.com.zup.edu.pawspets.pets.consulta;

import br.com.zup.edu.pawspets.pets.Raca;

import java.util.StringJoiner;

public class RacaResponse {
    private Long id;

    private String nome;

    public RacaResponse(Raca raca) {

        this.id = raca.getId();
        this.nome = raca.getNome();
    }

    /**
     * @deprecated para uso dos frameworks apenas
     */
    @Deprecated
    public RacaResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RacaResponse.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .toString();
    }
}
