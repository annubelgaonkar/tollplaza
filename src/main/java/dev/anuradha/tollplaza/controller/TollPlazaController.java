package dev.anuradha.tollplaza.controller;

import dev.anuradha.tollplaza.dto.BaseResponseDTO;
import dev.anuradha.tollplaza.dto.TollPlazaRequestDTO;
import dev.anuradha.tollplaza.dto.TollPlazaResponseDTO;
import dev.anuradha.tollplaza.service.TollPlazaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/toll-plazas")
@RequiredArgsConstructor
public class TollPlazaController {

    private final TollPlazaService tollPlazaService;

    @PostMapping
    public ResponseEntity<BaseResponseDTO<TollPlazaResponseDTO>> getTollPlazas(
            @Valid @RequestBody TollPlazaRequestDTO requestDTO){
        TollPlazaResponseDTO responseDTO = tollPlazaService
                .getTollPlazasOnRoute(requestDTO);

        String message = responseDTO.getTollPlazas().isEmpty()
                ? "No toll plazas found on the route"
                :"Toll plazas fetched successfully";
        return ResponseEntity.ok(BaseResponseDTO.success(message,responseDTO));
    }
}
