package com.calculato.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class SubstepNode {
    String derive;
    String rule;
    String description;
    String step_result;
    List<SubstepNode> substeps;
}
