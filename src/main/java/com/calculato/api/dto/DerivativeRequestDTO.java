package com.calculato.api.dto;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "Request object for derivation operation")
public class DerivativeRequestDTO {
        @Schema(description = "The mathematical expression to differentiate", example = "x^2 + sin(x)")
        String expression;
        @Schema(description = "The variable with respect to which the derivative is calculated", example = "x", defaultValue = "x")
        String variable;
}
