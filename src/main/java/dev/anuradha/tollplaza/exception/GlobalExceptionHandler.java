package dev.anuradha.tollplaza.exception;

<<<<<<< HEAD
import dev.anuradha.tollplaza.dto.BaseResponseDTO;
=======
import dev.anuradha.tollplaza.dto.ErrorResponseDTO;
>>>>>>> 9ef1208e9a64d7fc0524ece93740bc1cc6ecdc78
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SamePincodeException.class)
<<<<<<< HEAD
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
    public ResponseEntity<BaseResponseDTO<?>> handleGenericException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(BaseResponseDTO.failure("Something went wrong: "
                        + ex.getMessage()));
=======
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
>>>>>>> 9ef1208e9a64d7fc0524ece93740bc1cc6ecdc78
    }

}
