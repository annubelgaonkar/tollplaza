package dev.anuradha.tollplaza.service;

import dev.anuradha.tollplaza.model.TollPlaza;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RouteService {

    public double calculateDistance(String sourcePincode, String destinationPincode){
        if(sourcePincode.equals(destinationPincode)){
            throw new IllegalArgumentException(
                    "Source and destination pincodes cannot be the same");
        }
        return 200 + Math.random() * 1800;
    }

    public List<TollPlaza> filterTollPlazasOnRoute(
            List<TollPlaza> allPlazas,
            String sourcePincode,
            String destinationPincode
    ){
        return allPlazas;
    }
}
