package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T>{
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private HttpStatus status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T payload;
}
