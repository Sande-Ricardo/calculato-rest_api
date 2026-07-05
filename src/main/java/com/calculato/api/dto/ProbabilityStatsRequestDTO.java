package com.calculato.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Map;

@Data
@Schema(description = "Request object for probability distribution analysis")
public class ProbabilityStatsRequestDTO {

    @Schema(description = "The distribution type", example = "normal", allowableValues = {"normal", "t_student", "binomial", "poisson"})
    private String distribution;

    @Schema(description = "Distribution-specific parameters", example = "{\"mu\": 0, \"sigma\": 1}")
    private Map<String, Object> parameters;

    @Schema(description = "Type of query to perform", example = "cumulative_less", allowableValues = {"exact", "cumulative_less", "cumulative_greater", "between"})
    @JsonProperty("query_type")
    private String queryType;

    @Schema(description = "The evaluation point (float) or range [a, b] for 'between' queries", example = "1.96")
    @JsonProperty("query_value")
    private Object queryValue;
}
