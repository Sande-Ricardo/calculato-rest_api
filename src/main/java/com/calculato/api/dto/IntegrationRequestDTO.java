package com.calculato.api.dto;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "Request object for integration operation")
public class IntegrationRequestDTO {
    @Schema(description = "The mathematical expression to integrate", example = "x^2 + 3*x")
    private String expression;
    @Schema(description = "The integration variable", example = "x", defaultValue = "x")
    private String variable;

}
