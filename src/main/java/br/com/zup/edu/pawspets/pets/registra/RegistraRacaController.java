package br.com.zup.edu.pawspets.pets.registra;

import br.com.zup.edu.pawspets.pets.RacaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("/racas")
public class RegistraRacaController {

    private final RacaRepository racaRepository;

    public RegistraRacaController(RacaRepository racaRepository) {
        this.racaRepository = racaRepository;
    }


    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody RegistraRacaRequest request,
                                    UriComponentsBuilder uriBuilder) {

        var novaRaca = request.toModel();

        var salvo = racaRepository.save(novaRaca);

        var uri = uriBuilder.path("/racas/{id}")
                .buildAndExpand(salvo.getId())
                .toUri();

        return created(uri).build();
    }
}
