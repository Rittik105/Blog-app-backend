package com.springtutorial.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Integer id;

    @NotEmpty(message = "title can not be empty")
    private String title;

    private String description;
}
