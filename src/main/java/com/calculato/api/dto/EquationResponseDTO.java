package com.calculato.api.dto;

import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class EquationResponseDTO {
    private String status;
    
    @JsonProperty("original_expression")
    private String originalExpression;
    
    @JsonProperty("final_result")
    private List<String> finalResult; 
    
    private List<EquationStepNode> steps;
}
