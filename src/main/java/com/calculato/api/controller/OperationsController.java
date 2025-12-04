package com.calculato.api.controller;

import com.calculato.api.dto.IntegrationRequestDTO;
import com.calculato.api.dto.IntegrationResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.calculato.api.service.OperationsService;

@RestController
@RequestMapping("/op")
public class OperationsController {

    @Autowired
    private OperationsService operationsService;

    private final Logger logger = LoggerFactory.getLogger(OperationsController.class);


    @PostMapping("/derivation")
    public ResponseEntity<String> derivation(@RequestBody String expression){
        this.logger.debug(expression);
        return ResponseEntity.ok(operationsService.derivation(expression));
    }

    @PostMapping("/integration")
    public ResponseEntity<IntegrationResponseDTO> integration(@RequestBody IntegrationRequestDTO req){
        return ResponseEntity.ok(operationsService.integration(req));
    }

    @GetMapping("/test/{expression}")
    public String saludar(@PathVariable String expression) {
        return operationsService.derivation(expression);
    }

}
