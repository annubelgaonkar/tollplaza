package dev.anuradha.tollplaza.controller;

<<<<<<< HEAD
import dev.anuradha.tollplaza.dto.BaseResponseDTO;
import dev.anuradha.tollplaza.dto.TollPlazaRequestDTO;
import dev.anuradha.tollplaza.dto.TollPlazaResponseDTO;
=======
import dev.anuradha.tollplaza.dto.TollPlazaRequestDTO;
import dev.anuradha.tollplaza.dto.TollPlazaResponseDTO;
import dev.anuradha.tollplaza.model.TollPlaza;
>>>>>>> 9ef1208e9a64d7fc0524ece93740bc1cc6ecdc78
import dev.anuradha.tollplaza.service.TollPlazaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
=======
import java.util.Map;

>>>>>>> 9ef1208e9a64d7fc0524ece93740bc1cc6ecdc78
@RestController
@RequestMapping("/api/v1/toll-plazas")
@RequiredArgsConstructor
public class TollPlazaController {

    private final TollPlazaService tollPlazaService;

    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<BaseResponseDTO<TollPlazaResponseDTO>> getTollPlazas(
            @Valid @RequestBody TollPlazaRequestDTO requestDTO){
        TollPlazaResponseDTO responseDTO = tollPlazaService
                .getTollPlazasOnRoute(requestDTO);

        String message = responseDTO.getTollPlazas().isEmpty()
                ? "No toll plazas found on the route"
                :"Toll plazas fetched successfully";
        return ResponseEntity.ok(BaseResponseDTO.success(message,responseDTO));
=======
    public ResponseEntity<?> getTollPlazas(
            @Valid @RequestBody TollPlazaRequestDTO requestDTO){
        try{
            TollPlazaResponseDTO responseDTO = tollPlazaService
                    .getTollPlazasOnRoute(requestDTO);
            return ResponseEntity.ok(responseDTO);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
>>>>>>> 9ef1208e9a64d7fc0524ece93740bc1cc6ecdc78
    }
}
