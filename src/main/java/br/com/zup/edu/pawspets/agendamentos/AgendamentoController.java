package br.com.zup.edu.pawspets.agendamentos;

import br.com.zup.edu.pawspets.pets.PetRepository;
import br.com.zup.edu.pawspets.servicos.ServicoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final ServicoRepository servicoRepository;

    private final PetRepository petRepository;

    private final AgendamentoRepository agendamentoRepository;

    private Logger logger = LoggerFactory.getLogger(AgendamentoController.class);

    public AgendamentoController(ServicoRepository servicoRepository,
                                 PetRepository petRepository,
                                 AgendamentoRepository agendamentoRepository) {
        this.servicoRepository = servicoRepository;
        this.petRepository = petRepository;
        this.agendamentoRepository = agendamentoRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastraAgendamento(@RequestBody @Valid CadastraAgendamentoRequest request,
                                                 UriComponentsBuilder uriComponentsBuilder) {
        Agendamento novoAgendamento = request.toAgendamento(petRepository, servicoRepository);

        agendamentoRepository.save(novoAgendamento);

        logger.info("Agendamento com id {} cadastrado com sucesso!", novoAgendamento.getId());

        URI location = uriComponentsBuilder
                .path("/agendamentos/{id}")
                .buildAndExpand(novoAgendamento.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
