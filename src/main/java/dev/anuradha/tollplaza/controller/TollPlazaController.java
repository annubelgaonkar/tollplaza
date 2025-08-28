package dev.anuradha.tollplaza.controller;

import dev.anuradha.tollplaza.dto.TollPlazaRequestDTO;
import dev.anuradha.tollplaza.dto.TollPlazaResponseDTO;
import dev.anuradha.tollplaza.model.TollPlaza;
import dev.anuradha.tollplaza.service.TollPlazaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/toll-plazas")
@RequiredArgsConstructor
public class TollPlazaController {

    private final TollPlazaService tollPlazaService;

    @PostMapping
    public ResponseEntity<?> getTollPlazas(
            @Valid @RequestBody TollPlazaRequestDTO requestDTO){
        try{
            TollPlazaResponseDTO responseDTO = tollPlazaService
                    .getTollPlazasOnRoute(requestDTO);
            return ResponseEntity.ok(responseDTO);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
