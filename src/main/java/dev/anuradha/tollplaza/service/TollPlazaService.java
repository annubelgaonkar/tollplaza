package dev.anuradha.tollplaza.service;

import dev.anuradha.tollplaza.dto.RouteInfoDTO;
import dev.anuradha.tollplaza.dto.TollPlazaDTO;
import dev.anuradha.tollplaza.dto.TollPlazaRequestDTO;
import dev.anuradha.tollplaza.dto.TollPlazaResponseDTO;
import dev.anuradha.tollplaza.model.TollPlaza;
import dev.anuradha.tollplaza.repository.TollPlazaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TollPlazaService {

    private final TollPlazaRepository repository;
    private final RouteService routeService;
`
    public TollPlazaResponseDTO getTollPlazasOnRoute(TollPlazaRequestDTO request){
        String source = request.getSourcePincode();
        String dest = request.getDestinationPincode();

        //1. calculate the route distance
        double distance = routeService.calculateDistance(source, dest);

        //2. Fetch all toll plazas
        List<TollPlaza> allPlazaList = repository.findAll();

        //3. Filter toll plazas on route
        List<TollPlaza> onRoute =
                routeService.filterTollPlazasOnRoute(allPlazaList, source, dest);

        //4. Map to DTO
        List<TollPlazaDTO> dtos = new ArrayList<>();
        for(TollPlaza plaza : onRoute){
            // Mock distanceFromSource (random fraction of total distance)
            double distanceFromSource = Math.random() * distance;
            dtos.add(new TollPlazaDTO(plaza.getName(),
                    plaza.getLatitude(),
                    plaza.getLongitude(),
                    distanceFromSource));
        }

        //5. Build Response
        RouteInfoDTO routeInfoDTO = new RouteInfoDTO(source,dest,distance);
        return new TollPlazaResponseDTO(routeInfoDTO, dtos);
    }
}
