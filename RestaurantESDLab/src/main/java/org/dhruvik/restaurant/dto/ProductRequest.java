package org.dhruvik.restaurant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest (
        @NotBlank(message = "Product name is required")
        @JsonProperty("product_name")
        String productName,

        @NotNull(message = "Product price is required")
        @Positive(message = "Product price must be a positive number")
        @JsonProperty("product_price")
        Double productPrice
)
{
}
