package dev.anuradha.tollplaza.exception;

import dev.anuradha.tollplaza.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SamePincodeException.class)
    public ResponseEntity<ErrorResponseDTO> handleSamePincode(SamePincodeException ex){
        return ResponseEntity.badRequest().body(
                new ErrorResponseDTO(
                        "Invalid Request",
                        ex.getMessage(),
                        LocalDateTime.now()
                )
        );
    }

    @ExceptionHandler(InvalidPincodeException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidPincode(InvalidPincodeException ex){
        return ResponseEntity.badRequest().body(
                new ErrorResponseDTO(
                        "Invalid Pincode",
                        ex.getMessage(),
                        LocalDateTime.now()
                )
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationErrors(
            MethodArgumentNotValidException ex){
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseEntity.badRequest().body(
                new ErrorResponseDTO(
                        "Validation error",
                        errorMessage,
                        LocalDateTime.now()
                )
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGenericException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        new ErrorResponseDTO("Internal Server error",
                                ex.getMessage(),
                                LocalDateTime.now())
                );
    }

}
