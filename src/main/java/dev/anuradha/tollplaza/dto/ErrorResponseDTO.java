package dev.anuradha.tollplaza.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {
    private String error;
    private String details;
    private LocalDateTime timestamp;
}
