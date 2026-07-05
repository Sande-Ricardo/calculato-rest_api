package com.calculato.api.controller;

import com.calculato.api.dto.OdeSlopeFieldRequestDTO;
import com.calculato.api.dto.OdeSlopeFieldResponseDTO;
import com.calculato.api.dto.OdeSolveRequestDTO;
import com.calculato.api.dto.OdeSolveResponseDTO;
import com.calculato.api.service.OdeService;
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
@RequestMapping("/ode")
@Tag(name = "Differential Equations", description = "Endpoints for solving ODEs and generating slope fields")
public class OdeController {

    private final Logger logger = LoggerFactory.getLogger(OdeController.class);

    private final OdeService odeService;

    @Autowired
    public OdeController(OdeService odeService) {
        this.odeService = odeService;
    }

    @Operation(summary = "Solve ODE", description = "Symbolically parses and solves an ordinary differential equation, returning pedagogical steps.")
    @PostMapping("/solve")
    public ResponseEntity<OdeSolveResponseDTO> solveOde(@RequestBody OdeSolveRequestDTO req) {
        logger.debug("Received ODE solve request for equation: {}", req.getEquation());
        return ResponseEntity.ok(odeService.solveOde(req));
    }

    @Operation(summary = "Slope Field", description = "Generates numerical grid vectors (slopes) for rendering flow fields of first-order differential equations.")
    @PostMapping("/slope-field")
    public ResponseEntity<OdeSlopeFieldResponseDTO> getSlopeField(@RequestBody OdeSlopeFieldRequestDTO req) {
        logger.debug("Received ODE slope field request for dy/dx: {}", req.getEquationDyDx());
        return ResponseEntity.ok(odeService.getSlopeField(req));
    }
}
