package dev.anuradha.tollplaza.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseDTO<T> {

    private boolean success;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public static <T> BaseResponseDTO<T> success(String message, T data){
        return new BaseResponseDTO<>(
                true,
                message,
                data,
                LocalDateTime.now()
        );
    }

    public static <T> BaseResponseDTO<T> failure(String message){
        return new BaseResponseDTO<>(false,
                message,
                null,
                LocalDateTime.now()
        );
    }

}
