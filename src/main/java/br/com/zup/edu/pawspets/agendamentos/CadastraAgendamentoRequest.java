package br.com.zup.edu.pawspets.agendamentos;

import br.com.zup.edu.pawspets.pets.Pet;
import br.com.zup.edu.pawspets.pets.PetRepository;
import br.com.zup.edu.pawspets.servicos.Servico;
import br.com.zup.edu.pawspets.servicos.ServicoRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

public class CadastraAgendamentoRequest {
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime horario;

    @NotNull
    @PositiveOrZero
    private Long petId;

    @NotNull
    @PositiveOrZero
    private Long servicoId;

    @NotNull
    private Status status;

    public LocalDateTime getHorario() {
        return horario;
    }

    public Long getPetId() {
        return petId;
    }

    public Long getServicoId() {
        return servicoId;
    }

    public Status getStatus() {
        return status;
    }

    public Agendamento toAgendamento(PetRepository petRepository, ServicoRepository servicoRepository) {

        Pet pet = petRepository.findById(petId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Pet não encontrado"));

        Servico servico = servicoRepository.findById(servicoId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Serviço não encontrado"));

        return new Agendamento(horario, pet, servico, status);
    }
}
