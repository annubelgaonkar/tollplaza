package dev.anuradha.tollplaza.service;

import dev.anuradha.tollplaza.exception.InvalidPincodeException;
import dev.anuradha.tollplaza.exception.SamePincodeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = RouteService.class)
class RouteServiceTest {

    @Autowired
    private RouteService routeService;

    @Test
    void testCalculateDistanceBetweenBangaloreAndDelhi(){
        double distance = routeService.calculateDistance("110001",
                "560001");
        assertTrue(distance > 1000 && distance < 3000,
                "Distance should be realistic between Bangalore & Delhi");
    }

    @Test
    void testSamePincodeThrowsException(){
        assertThrows(SamePincodeException.class, () ->
            routeService.calculateDistance("110001",
                    "110001")
        );
    }

    @Test
    void testInvalidPincodeThrowsException(){
        assertThrows(InvalidPincodeException.class, () ->
            routeService.calculateDistance("123",
                    "560001")
        );
    }
}