package com.calculato.api.dto;

import lombok.Data;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "Response object containing step-by-step integration")
public class IntegrationResponseDTO {
    @Schema(description = "The original input expression")
    private String expression;
    @Schema(description = "The integration variable used")
    private String variable;
    @Schema(description = "The raw string representation of the integrated result")
    private String result;
    @Schema(description = "The final integrated result formatted in LaTeX")
    private String latex;

    private StepNode step;
    @Schema(description = "A hierarchical dictionary detailing the integration rules applied")
    private StepNode steps;

}
