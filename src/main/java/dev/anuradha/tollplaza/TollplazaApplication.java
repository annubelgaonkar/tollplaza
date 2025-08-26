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

    @Bean
    CommandLineRunner initDatabase(TollPlazaRepository repository){
        return args -> {
            repository.save(new TollPlaza(null, "Bangalore Toll Plaza", 12.9716, 77.5946));
            repository.save(new TollPlaza(null, "Delhi Toll Plaza", 28.7041, 77.1025));
            repository.save(new TollPlaza(null, "Mumbai Toll Plaza", 19.076, 72.8777));
            repository.save(new TollPlaza(null, "Pune Toll Plaza", 18.5204, 73.8567));
        };
    }

}
