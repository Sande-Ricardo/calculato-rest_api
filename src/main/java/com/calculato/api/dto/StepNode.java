package com.calculato.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class StepNode {

    private String rule;       // nombre de la clase/regla en Sympy
    private String integrand;  // LaTeX del integrando
    private String variable;   // "x", "t", etc.

    // Parámetros opcionales
    private String constant;
    private String other;
    private String base;
    private String exp;

    // Estructura recursiva
    private StepNode substep;       // un subpaso
    private List<StepNode> substeps; // lista de subpasos

}
