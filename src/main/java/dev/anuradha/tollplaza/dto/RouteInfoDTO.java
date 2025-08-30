package dev.anuradha.tollplaza.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RouteInfoDTO {
    private String sourcePincode;
    private String destinationPincode;
    private double distanceInKm;
}
