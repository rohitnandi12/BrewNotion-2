package com.brewnotion.blog.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {

    private Integer categoryId;

    @NotEmpty
    @Size(min = 4)
    private String categoryTitle;

    @NotNull
    @Size(min = 10)
    private String categoryDescription;
}
