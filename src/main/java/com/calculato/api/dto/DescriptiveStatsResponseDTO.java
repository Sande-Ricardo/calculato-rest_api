package com.calculato.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Map;

@Data
@Schema(description = "Response object containing descriptive statistics analysis results")
public class DescriptiveStatsResponseDTO {

    @Schema(description = "Execution status", example = "success")
    private String status;

    @Schema(description = "The statistical results object")
    private Map<String, Object> data;
}
