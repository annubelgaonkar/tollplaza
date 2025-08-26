package dev.anuradha.tollplaza.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TollPlazaDTO {

    private String name;
    private double latitude;
    private double longitude;
    private double distanceFromSource;
}
