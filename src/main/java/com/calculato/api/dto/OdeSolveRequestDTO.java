package com.calculato.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Request object for ODE solving operation")
public class OdeSolveRequestDTO {
    @Schema(description = "The ordinary differential equation to solve", example = "y' + 2*y = exp(x)")
    private String equation;

    @Schema(description = "The independent variable of the ODE", example = "x", defaultValue = "x")
    @JsonProperty("independent_var")
    private String independentVar = "x";

    @Schema(description = "The dependent variable (function) of the ODE", example = "y", defaultValue = "y")
    @JsonProperty("dependent_var")
    private String dependentVar = "y";

    @Schema(description = "Boundary conditions for Initial Value Problems")
    @JsonProperty("initial_conditions")
    private InitialConditionsDTO initialConditions;
}
