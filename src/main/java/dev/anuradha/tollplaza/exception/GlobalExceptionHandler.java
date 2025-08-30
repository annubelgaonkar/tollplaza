package dev.anuradha.tollplaza.exception;

import dev.anuradha.tollplaza.dto.BaseResponseDTO;
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

    public ResponseEntity<BaseResponseDTO<?>> handleSamePincode(SamePincodeException ex){
        return ResponseEntity.badRequest()
                .body(BaseResponseDTO
                        .failure(ex.getMessage()));
    }

    @ExceptionHandler(InvalidPincodeException.class)
    public ResponseEntity<BaseResponseDTO<?>> handleInvalidPincode(
            InvalidPincodeException ex){
        return ResponseEntity.badRequest()
                .body(BaseResponseDTO
                        .failure(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponseDTO<?>> handleValidationErrors(
            MethodArgumentNotValidException ex)
    {
        String errorMessage = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        return ResponseEntity.badRequest().body(BaseResponseDTO.failure(errorMessage));
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
