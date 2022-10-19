package br.com.zup.edu.pawspets.vacinacao;

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

    private VacinaRepository vacinaRepository;

    @Autowired
    public VacinaController(VacinaRepository vacinaRepository) {
        this.vacinaRepository = vacinaRepository;
    }


    @PostMapping
    public ResponseEntity<?> cadastraVacina(@RequestBody @Valid VacinaRequest request, UriComponentsBuilder builder) {

        Vacina vacina = request.toVacina();
        vacinaRepository.save(vacina);

        URI location = builder.path("/vacinas/{idVacina}").buildAndExpand(vacina.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
