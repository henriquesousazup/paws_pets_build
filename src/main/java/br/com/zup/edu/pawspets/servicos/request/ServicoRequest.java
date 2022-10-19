package br.com.zup.edu.pawspets.servicos.request;

import br.com.zup.edu.pawspets.servicos.Servico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ServicoRequest {

    @NotBlank
    private String nome;

    @Positive
    private BigDecimal valor;

    public ServicoRequest(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Deprecated
    public ServicoRequest() {
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Servico toModel() {
        return new Servico(this.nome, this.valor);
    }
}
