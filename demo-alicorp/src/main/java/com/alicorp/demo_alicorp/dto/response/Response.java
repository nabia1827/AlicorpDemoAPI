package com.alicorp.demo_alicorp.dto.response;
import lombok.Data;

@Data
public class Response<T> {
    private Boolean success;
    private String message;
    private T data;
}
