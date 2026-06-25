package com.calculato.api.dto;

import lombok.Data;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "Request object for matrix operations")
public class MatrixRequestDTO {
    @Schema(description = "A 2D array representation of the matrix", example = "[[\"2\", \"1\"], [\"1\", \"3\"]]")
    private List<List<String>> matrix;
    @Schema(description = "The operation to perform", example = "inverse", allowableValues = {"inverse", "determinant", "rref"})
    private String operation;
    @Schema(description = "Resolution mode", example = "symbolic", allowableValues = {"symbolic", "numeric"}, defaultValue = "symbolic")
    private String mode;
}
