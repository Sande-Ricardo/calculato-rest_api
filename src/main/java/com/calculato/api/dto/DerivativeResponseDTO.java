package com.calculato.api.dto;

import lombok.Data;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "Response object containing step-by-step derivation")
public class DerivativeResponseDTO {
    @Schema(description = "The LaTeX representation of the derivation operation being performed")
    String derive;
    @Schema(description = "The mathematical rule applied")
    String rule;
    @Schema(description = "The LaTeX formatted result of the current step")
    String step_result;
    @Schema(description = "An array of recursive step objects detailing the breakdown of complex rules")
    List<SubstepNode> substeps;
}
