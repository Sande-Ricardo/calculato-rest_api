package com.calculato.api.controller;

import com.calculato.api.dto.DerivativeRequestDTO;
import com.calculato.api.dto.DerivativeResponseDTO;
import com.calculato.api.dto.EquationRequestDTO;
import com.calculato.api.dto.EquationResponseDTO;
import com.calculato.api.dto.IntegrationRequestDTO;
import com.calculato.api.dto.IntegrationResponseDTO;
import com.calculato.api.dto.MatrixRequestDTO;
import com.calculato.api.dto.MatrixResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.calculato.api.service.OperationsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/op")
@Tag(name = "Operations", description = "Mathematical operations endpoints")
public class OperationsController {

    @Autowired
    private OperationsService operationsService;

    private final Logger logger = LoggerFactory.getLogger(OperationsController.class);

    @Operation(summary = "Calculate Derivative", description = "Calculates the symbolic derivative of a mathematical expression step-by-step.")
    @PostMapping("/derivation")
    public ResponseEntity<DerivativeResponseDTO> derivation(@RequestBody DerivativeRequestDTO req) {
        this.logger.debug(req.getExpression());
        return ResponseEntity.ok(operationsService.derivation(req));
    }

    @Operation(summary = "Calculate Integral", description = "Calculates the symbolic integral of a mathematical expression step-by-step.")
    @PostMapping("/integration")
    public ResponseEntity<IntegrationResponseDTO> integration(@RequestBody IntegrationRequestDTO req) {
        return ResponseEntity.ok(operationsService.integration(req));
    }

    @Operation(summary = "Resolve Equation", description = "Performs algebraic operations and solves equations step-by-step.")
    @PostMapping("/equation")
    public ResponseEntity<EquationResponseDTO> equation(@RequestBody EquationRequestDTO req) {
        this.logger.debug("Received equation operation for: {}", req.getExpression());
        return ResponseEntity.ok(operationsService.equation(req));
    }

    @Operation(summary = "Matrix Operations", description = "Performs linear algebra operations on matrices (inverse, determinant, rref).")
    @PostMapping("/matrix")
    public ResponseEntity<MatrixResponseDTO> matrix(@RequestBody MatrixRequestDTO req) {
        this.logger.debug("Received matrix operation for: {}", req.getOperation());
        return ResponseEntity.ok(operationsService.matrix(req));
    }

    @Operation(summary = "Test Derivative", description = "Quick GET endpoint to test derivation of a simple expression with variable x.")
    @GetMapping("/test/{expression}")
    public String saludar(@PathVariable String expression) {
        DerivativeRequestDTO reqTest = new DerivativeRequestDTO();
        reqTest.setExpression(expression);
        reqTest.setVariable("x");
        return operationsService.derivation(reqTest).getDerive();
    }

}
