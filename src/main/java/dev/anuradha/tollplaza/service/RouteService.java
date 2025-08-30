package dev.anuradha.tollplaza.service;

import dev.anuradha.tollplaza.exception.InvalidPincodeException;
import dev.anuradha.tollplaza.exception.SamePincodeException;
import dev.anuradha.tollplaza.model.TollPlaza;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RouteService {

    public double calculateDistance(String sourcePincode,
                                    String destinationPincode){
        if(sourcePincode.equals(destinationPincode)){
            throw new SamePincodeException(
                    "Source and destination pincodes cannot be the same");
        }
        if(!isValidPincode(sourcePincode) || !isValidPincode(destinationPincode)){
            throw new InvalidPincodeException("Invalid source or destination pincode");
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
    private boolean isValidPincode(String pincode){
        return pincode != null && pincode.matches("\\d{6}");

    }
}
