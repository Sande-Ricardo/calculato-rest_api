package com.calculato.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Object containing the initial conditions for solving the ODE")
public class InitialConditionsDTO {
    @Schema(description = "Initial independent variable value", example = "0")
    private Double x0;

    @Schema(description = "Initial dependent variable value", example = "1")
    private Double y0;
    
    @Schema(description = "Initial first derivative value (for second order ODEs)")
    private Double y0_prime;
}
