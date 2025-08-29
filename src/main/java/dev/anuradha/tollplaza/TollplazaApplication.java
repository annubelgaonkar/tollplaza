package dev.anuradha.tollplaza;

import dev.anuradha.tollplaza.model.TollPlaza;
import dev.anuradha.tollplaza.repository.TollPlazaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TollplazaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TollplazaApplication.class, args);
    }
}
