package com.example.digitallibrary.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiException extends RuntimeException{
    private String message;
}
