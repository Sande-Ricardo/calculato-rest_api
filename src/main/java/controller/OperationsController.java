package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.OperationsService;

@RestController
@RequestMapping("/op")
public class OperationsController {

    @Autowired
    private OperationsService operationsService;



    @PostMapping("/derivation")
    public ResponseEntity<String> derivation(@RequestBody String expression){
        return ResponseEntity.ok(operationsService.derivation(expression));
    }

    @PostMapping("/integration")
    public ResponseEntity<String> integration(@RequestBody String expression){
        return ResponseEntity.ok(operationsService.integration(expression));
    }

}
