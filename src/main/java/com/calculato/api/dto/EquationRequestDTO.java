package com.calculato.api.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Request object for equation resolution operation")
public class EquationRequestDTO {
    @Schema(description = "The equation or expression in LaTeX format", example = "x^2 + 5x + 6 = 0")
    private String expression;
    @Schema(description = "The operation to perform", example = "solve", allowableValues = {"solve", "factorize", "expand", "simplify"})
    private String operation;
    
    @Schema(description = "The variable to solve for", example = "x", defaultValue = "x")
    @JsonProperty("target_variable")
    private String targetVariable;
    
    @Schema(description = "The specific solving method", example = "factorization", allowableValues = {"factorization", "general_formula", "quadratic_formula", "default"})
    private String method;
}
