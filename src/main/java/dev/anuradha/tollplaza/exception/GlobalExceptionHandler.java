package dev.anuradha.tollplaza.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SamePincodeException.class)
    public ResponseEntity<Map<String, String>> handleSamePincode(SamePincodeException ex){
        return ResponseEntity.badRequest().body(
                Map.of()
        )
    }
}
