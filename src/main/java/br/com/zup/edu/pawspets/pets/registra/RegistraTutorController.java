package br.com.zup.edu.pawspets.pets.registra;

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
@RequestMapping("/tutores")
public class RegistraTutorController {

    private final TutorRepository tutorRepository;

    public RegistraTutorController(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody RegistraTutorRequest request,
                                    UriComponentsBuilder uriBuilder) {


        var novoTutor = request.toModel();

        var salvo = tutorRepository.save(novoTutor);

        var uri = uriBuilder.path("/tutor/{id}")
                .buildAndExpand(salvo.getId())
                .toUri();

        return created(uri).build();
    }
}
