package com.calculato.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Map;

@Data
@Schema(description = "Response object containing probability distribution analysis results")
public class ProbabilityStatsResponseDTO {

    @Schema(description = "Execution status", example = "success")
    private String status;

    @Schema(description = "The analyzed distribution name")
    private String distribution;

    @Schema(description = "Computed probability and description")
    private Map<String, Object> calculation;

    @Schema(description = "Data for rendering charts (curve points, shaded regions, etc.)")
    @JsonProperty("chart_data")
    private Map<String, Object> chartData;
}
