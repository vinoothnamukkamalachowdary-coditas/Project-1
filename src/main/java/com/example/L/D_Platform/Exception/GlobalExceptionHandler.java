package com.example.L.D_Platform.Exception;

import com.example.L.D_Platform.CommonResponse.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<APIResponse<?>> handleException(ResourceNotFound e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse<>(false, e.getMessage(),  null));
    }
}
