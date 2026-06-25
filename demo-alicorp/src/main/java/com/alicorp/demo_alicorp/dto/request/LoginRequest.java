package com.alicorp.demo_alicorp.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class LoginRequest {

    private String username;

    private String password;
}