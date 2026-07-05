package com.calculato.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Object containing the grid configuration for generating slope fields")
public class GridConfigDTO {
    @Schema(description = "Minimum independent variable limit", example = "-5")
    @JsonProperty("x_min")
    private Double xMin;

    @Schema(description = "Maximum independent variable limit", example = "5")
    @JsonProperty("x_max")
    private Double xMax;

    @Schema(description = "Number of steps along the independent variable axis", example = "25")
    @JsonProperty("x_steps")
    private Integer xSteps;

    @Schema(description = "Minimum dependent variable limit", example = "-5")
    @JsonProperty("y_min")
    private Double yMin;

    @Schema(description = "Maximum dependent variable limit", example = "5")
    @JsonProperty("y_max")
    private Double yMax;

    @Schema(description = "Number of steps along the dependent variable axis", example = "25")
    @JsonProperty("y_steps")
    private Integer ySteps;
}
