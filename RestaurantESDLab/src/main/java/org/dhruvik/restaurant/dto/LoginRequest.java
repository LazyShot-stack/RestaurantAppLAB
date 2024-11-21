package org.dhruvik.restaurant.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "Email is required")
        @Email(message = "Email must be in correct format")
        String email,

        @NotBlank(message = " Password is required")
        String password
) {
}
