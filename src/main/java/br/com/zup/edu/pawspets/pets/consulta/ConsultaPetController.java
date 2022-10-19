package br.com.zup.edu.pawspets.pets.consulta;

import br.com.zup.edu.pawspets.pets.Pet;
import br.com.zup.edu.pawspets.pets.PetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/pets")
public class ConsultaPetController {

    private final PetRepository repository;

    public ConsultaPetController(PetRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public ResponseEntity<?> buscaPets(@RequestParam("tutor") Long id,
                                       @PageableDefault Pageable page) {

        if (id == null) {
            Page<Pet> pets = repository.findAll(page);

            Page<PetResponse> response = pets.map(PetResponse::new);

            return ResponseEntity.ok(response);
        }

        Page<Pet> pets = repository.buscaTodosOsPetsDoTutor(id, page);

        Page<PetResponse> response = pets.map(PetResponse::new);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPetsPor(@PathVariable("id") Long id) {


        Optional<Pet> possivelPet = repository.findById(id);

        if (possivelPet.isEmpty()) {
            return notFound().build();
        }


        return ResponseEntity.ok(new PetResponse(possivelPet.get()));
    }
}
