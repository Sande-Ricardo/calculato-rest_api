package com.calculato.api.dto;

import lombok.Data;
import java.util.List;

@Data
public class MatrixResponseDTO {
    private String status;
    private String operation;
    private List<List<String>> result;
    private List<MatrixStepNode> steps;
}
