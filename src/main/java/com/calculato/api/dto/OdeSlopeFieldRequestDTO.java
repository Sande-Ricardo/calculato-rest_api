package com.calculato.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Request object for ODE slope field generation")
public class OdeSlopeFieldRequestDTO {
    @Schema(description = "The expression representing dy/dx", example = "exp(x) - 2*y")
    @JsonProperty("equation_dy_dx")
    private String equationDyDx;

    @Schema(description = "The independent variable of the ODE", example = "x", defaultValue = "x")
    @JsonProperty("independent_var")
    private String independentVar = "x";

    @Schema(description = "The dependent variable (function) of the ODE", example = "y", defaultValue = "y")
    @JsonProperty("dependent_var")
    private String dependentVar = "y";

    @Schema(description = "The grid range and resolution details")
    private GridConfigDTO grid;
}
