package br.com.zup.edu.pawspets;

import br.com.zup.edu.pawspets.pets.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PawsPetsApplication  implements CommandLineRunner {

    @Autowired
    private RacaRepository racaRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private PetRepository petRepository;

    public static void main(String[] args) {
        SpringApplication.run(PawsPetsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Raca dachshund = new Raca("dachshund");
        racaRepository.save(dachshund);

        Tutor henrique = new Tutor("Henrique", "20221449027", "+5511941008241");
        tutorRepository.save(henrique);

        Pet simba = new Pet("Simba", dachshund, 9, henrique, Sexo.MACHO);
        petRepository.save(simba);
    }
}
