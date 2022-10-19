package br.com.zup.edu.pawspets.pets;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query("select p from Pet p where p.tutor.id = :tutorId")
    Page<Pet> buscaTodosOsPetsDoTutor(Long tutorId, Pageable page);
}
