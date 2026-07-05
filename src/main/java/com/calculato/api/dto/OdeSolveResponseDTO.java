package com.calculato.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Response object containing step-by-step ODE resolution")
public class OdeSolveResponseDTO {
    @Schema(description = "Execution status", example = "success")
    private String status;

    @Schema(description = "The internal SymPy classification ID of the ODE", example = "1st_linear")
    @JsonProperty("classification_id")
    private String classificationId;

    @Schema(description = "The human-readable name of the ODE classification", example = "1st order linear")
    @JsonProperty("classification_name")
    private String classificationName;

    @Schema(description = "The formatted general solution equation (LHS = RHS)")
    @JsonProperty("general_solution")
    private String generalSolution;

    @Schema(description = "The formatted particular solution equation (LHS = RHS) if initial conditions are met")
    @JsonProperty("particular_solution")
    private String particularSolution;

    @Schema(description = "A sequential list of pedagogical resolution steps")
    private List<OdeStepNode> steps;
}
