package com.calculato.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class DerivativeResponseDTO {
    String derive;
    String rule;
    String step_result;
    List<SubstepNode> substeps;
}
