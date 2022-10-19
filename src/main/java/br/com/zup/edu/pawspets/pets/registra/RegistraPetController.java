package br.com.zup.edu.pawspets.pets.registra;

import br.com.zup.edu.pawspets.pets.Pet;
import br.com.zup.edu.pawspets.pets.PetRepository;
import br.com.zup.edu.pawspets.pets.RacaRepository;
import br.com.zup.edu.pawspets.pets.TutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("/pets")
public class RegistraPetController {

    private final PetRepository petRepository;
    private final TutorRepository tutorRepository;
    private final RacaRepository racaRepository;

    public RegistraPetController(PetRepository petRepository,
                                 TutorRepository tutorRepository,
                                 RacaRepository racaRepository) {
        this.petRepository = petRepository;
        this.tutorRepository = tutorRepository;
        this.racaRepository = racaRepository;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody RegistraPetRequest request,
                                    UriComponentsBuilder uriBuilder) {


        var novoPet = request.toModel(tutorRepository, racaRepository);

        Pet salvo = petRepository.save(novoPet);

        var uri = uriBuilder.path("/pets/{id}")
                .buildAndExpand(salvo.getId())
                .toUri();

        return created(uri).build();
    }
}
