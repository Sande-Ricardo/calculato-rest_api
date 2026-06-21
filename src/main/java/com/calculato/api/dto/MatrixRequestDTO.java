package com.calculato.api.dto;

import lombok.Data;
import java.util.List;

@Data
public class MatrixRequestDTO {
    private List<List<String>> matrix;
    private String operation;
    private String mode;
}
