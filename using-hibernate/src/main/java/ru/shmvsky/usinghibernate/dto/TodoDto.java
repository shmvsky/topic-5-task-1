package ru.shmvsky.usinghibernate.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record TodoDto(
        @NotBlank
        @Length(min = 1, max = 100)
        String title,
        String description,
        boolean completed
) {
}
