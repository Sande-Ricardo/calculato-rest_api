package com.calculato.api.dto;

import lombok.Data;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "Response object containing step-by-step matrix operation resolution")
public class MatrixResponseDTO {
    @Schema(description = "The execution status", example = "success")
    private String status;
    @Schema(description = "The operation that was executed")
    private String operation;
    @Schema(description = "The final matrix result containing string representations of values")
    private List<List<String>> result;
    @Schema(description = "A sequential list of resolution steps")
    private List<MatrixStepNode> steps;
}
