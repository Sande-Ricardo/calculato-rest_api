package com.calculato.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Request object for descriptive statistics analysis")
public class DescriptiveStatsRequestDTO {

    @Schema(description = "The dataset to analyze", example = "[12.5, 14.2, 10.1, 15.6, 12.5, 18.9, 11.0, 9.5, 45.0]")
    private List<Float> dataset;

    @Schema(description = "True if the dataset represents a sample (uses n-1 degrees of freedom), false for population (uses n)", example = "true", defaultValue = "true")
    private Boolean sample = true;
}
