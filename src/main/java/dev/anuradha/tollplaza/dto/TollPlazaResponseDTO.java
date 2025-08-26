package dev.anuradha.tollplaza.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TollPlazaResponseDTO {
    private RouteInfoDTO route;
    private List<TollPlazaDTO> tollPlazas;
}
