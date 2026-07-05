package com.calculato.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Map;

@Data
@Schema(description = "Response object containing ODE slope field data")
public class OdeSlopeFieldResponseDTO {
    @Schema(description = "Execution status", example = "success")
    private String status;

    @Schema(description = "Coordinate and direction component lists")
    @JsonProperty("vector_field")
    private Map<String, Object> vectorField;
}
