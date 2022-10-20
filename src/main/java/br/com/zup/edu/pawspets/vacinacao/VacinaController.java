package br.com.zup.edu.pawspets.vacinacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {

    private final VacinaRepository vacinaRepository;

    private Logger logger = LoggerFactory.getLogger(VacinaController.class);

    @Autowired
    public VacinaController(VacinaRepository vacinaRepository) {
        this.vacinaRepository = vacinaRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastraVacina(@RequestBody @Valid VacinaRequest request, UriComponentsBuilder builder) {

        Vacina novaVacina = request.toVacina();
        vacinaRepository.save(novaVacina);

        logger.info("Vacina com id {} cadastrada com sucesso!", novaVacina.getId());

        URI location = builder.path("/vacinas/{idVacina}").buildAndExpand(novaVacina.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
