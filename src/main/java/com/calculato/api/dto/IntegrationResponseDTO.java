package com.calculato.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class IntegrationResponseDTO {
    private String expression;
    private String variable;
    private String result;
    private String latex;

    private StepNode step;
    private StepNode steps;

}
