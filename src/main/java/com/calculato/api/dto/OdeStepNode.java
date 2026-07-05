package com.calculato.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Represents a step in the ODE resolution process")
public class OdeStepNode {
    @Schema(description = "The sequential order of the step", example = "1")
    private Integer order;

    @Schema(description = "A human-readable description of the step")
    private String description;
    
    @Schema(description = "The mathematical state formatted in LaTeX")
    @JsonProperty("math_state")
    private String mathState;
}
