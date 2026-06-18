package com.calculato.api.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class EquationRequestDTO {
    private String expression;
    private String operation;
    
    @JsonProperty("target_variable")
    private String targetVariable;
    
    private String method;
}
