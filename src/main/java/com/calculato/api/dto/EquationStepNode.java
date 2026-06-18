package com.calculato.api.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class EquationStepNode {
    private Integer order;
    private String description;
    
    @JsonProperty("math_state")
    private String mathState;
}
