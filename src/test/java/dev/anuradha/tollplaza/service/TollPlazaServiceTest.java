package dev.anuradha.tollplaza.service;

import dev.anuradha.tollplaza.dto.TollPlazaRequestDTO;
import dev.anuradha.tollplaza.dto.TollPlazaResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TollPlazaServiceTest {

    @Autowired
    private TollPlazaService tollPlazaService;

    @Test
    void testNoTollPlazasOnRoute(){
        TollPlazaRequestDTO request = new TollPlazaRequestDTO();
        request.setSourcePincode("600001");
        request.setDestinationPincode("560001");

        TollPlazaResponseDTO responseDTO = tollPlazaService
                .getTollPlazasOnRoute(request);

        assertTrue(responseDTO.getTollPlazas().isEmpty(),
                "Expected no toll plazas on this route");
    }

    @Test
    void testSomeTollPlazasOnRoute(){
        TollPlazaRequestDTO request = new TollPlazaRequestDTO();
        request.setSourcePincode("110001");
        request.setDestinationPincode("400001");


        TollPlazaResponseDTO response = tollPlazaService
                .getTollPlazasOnRoute(request);

        assertFalse(response.getTollPlazas().isEmpty(),
                "Expected some toll plazas between Delhi and Mumbai");
    }
}