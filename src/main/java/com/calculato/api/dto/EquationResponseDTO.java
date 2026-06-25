package com.calculato.api.dto;

import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "Response object containing step-by-step equation resolution")
public class EquationResponseDTO {
    @Schema(description = "The execution status", example = "success")
    private String status;
    
    @Schema(description = "The original LaTeX expression provided in the request")
    @JsonProperty("original_expression")
    private String originalExpression;
    
    @Schema(description = "The final result as an array of LaTeX formatted strings")
    @JsonProperty("final_result")
    private List<String> finalResult; 
    
    @Schema(description = "A sequential list of resolution steps")
    private List<EquationStepNode> steps;
}
