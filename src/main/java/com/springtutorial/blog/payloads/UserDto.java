package com.springtutorial.blog.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;
    @NotEmpty
    @Size(min = 4, message = "Name must be at least 4 characters")
    private String name;
    @Email(message = "Email is invalid")
    private String email;
    @NotEmpty
    @Size(min = 6, message = "Password needs to be at least 6 characters long")
    private String password;
    @NotEmpty
    private String about;
}
