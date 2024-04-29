package com.springtutorial.blog.payloads;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
public class ApiResponse {
    String message;
    Boolean success;

    public ApiResponse(String message, Boolean success){
        this.message = message;
        this.success = success;
    }
}
