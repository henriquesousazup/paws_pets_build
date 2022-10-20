package br.com.zup.edu.pawspets.servicos;

import br.com.zup.edu.pawspets.servicos.request.ServicoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/servicos")
public class CadastrarServicoController {

    private final ServicoRepository servicoRepository;

    private Logger logger = LoggerFactory.getLogger(CadastrarServicoController.class);

    public CadastrarServicoController(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastraServico(@RequestBody @Valid ServicoRequest servicoRequest, UriComponentsBuilder uriComponentsBuilder) {

        Servico novoServico = servicoRequest.toModel();

        servicoRepository.save(novoServico);

        logger.info("Serviço com id {} cadastrado com sucesso!", novoServico.getId());

        URI location = uriComponentsBuilder.path("/servicos/{id}").buildAndExpand(novoServico.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
