package br.com.zup.edu.pawspets.pets.consulta;

import br.com.zup.edu.pawspets.pets.Tutor;

import java.util.StringJoiner;

public class TutorResponse {
    private Long id;

    private String nome;

    private String documento;

    private String telefone;

    public TutorResponse(Tutor tutor) {
        this.id = tutor.getId();
        this.nome = tutor.getNome();
        this.documento = tutor.getDocumento();
        this.telefone = tutor.getTelefone();
    }

    /**
     * @deprecated para uso dos frameworks apenas
     */
    @Deprecated
    public TutorResponse() {
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
    public String toString() {
        return new StringJoiner(", ", TutorResponse.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .add("documento='" + documento + "'")
                .add("telefone='" + telefone + "'")
                .toString();
    }
}
