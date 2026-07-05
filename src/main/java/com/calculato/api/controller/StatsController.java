package com.calculato.api.controller;

import com.calculato.api.dto.DescriptiveStatsRequestDTO;
import com.calculato.api.dto.DescriptiveStatsResponseDTO;
import com.calculato.api.dto.ProbabilityStatsRequestDTO;
import com.calculato.api.dto.ProbabilityStatsResponseDTO;
import com.calculato.api.service.StatsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
@Tag(name = "Statistics", description = "Endpoints for statistical analysis and probability distributions")
public class StatsController {

    private final Logger logger = LoggerFactory.getLogger(StatsController.class);

    private final StatsService statsService;

    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @Operation(summary = "Descriptive Statistics", description = "Processes a 1D dataset to return central tendency, dispersion, position metrics, outliers, and histogram visualization data.")
    @PostMapping("/descriptive")
    public ResponseEntity<DescriptiveStatsResponseDTO> getDescriptiveStats(@RequestBody DescriptiveStatsRequestDTO req) {
        logger.debug("Received descriptive stats request");
        return ResponseEntity.ok(statsService.getDescriptiveStats(req));
    }

    @Operation(summary = "Probability Distributions", description = "Computes probability values and coordinate points for continuous and discrete probability distributions.")
    @PostMapping("/probability")
    public ResponseEntity<ProbabilityStatsResponseDTO> getProbabilityStats(@RequestBody ProbabilityStatsRequestDTO req) {
        logger.debug("Received probability stats request for distribution: {}", req.getDistribution());
        return ResponseEntity.ok(statsService.getProbabilityStats(req));
    }
}
