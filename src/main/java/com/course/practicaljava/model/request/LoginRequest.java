package com.course.practicaljava.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class LoginRequest {
    @Schema( name = "username", example = "admin",  required = true)
    public String username;

    @Schema( name = "password", example = "0000",  required = true)
    public String password;
}
