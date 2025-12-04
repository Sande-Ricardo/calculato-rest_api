package com.calculato.api.service;

import com.calculato.api.dto.*;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactoryFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class OperationsService {

    private final Logger logger = LoggerFactory.getLogger(OperationsService.class);

    @Autowired
    private final RestTemplate restTemplate;

    @Value("${flask.microservice.url}")
    private String microserviceUrl;

//    private final RestTemplate restTemplate = new RestTemplate();

    public OperationsService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public String derivation(String expression){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        OperationRequest opRequest = new OperationRequest(expression);

        HttpEntity<OperationRequest> request = new HttpEntity<>(opRequest, headers);

        ResponseEntity<OperationResponse> response = restTemplate.exchange(
                (this.microserviceUrl + "/api/derivation"),
                HttpMethod.POST,
                request,
                OperationResponse.class
        );

        return response.getBody().result();
    }

    public IntegrationResponseDTO integration(IntegrationRequestDTO req){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<IntegrationRequestDTO> entity = new HttpEntity<>(req, headers);

        String url = this.microserviceUrl + "/api/integration";
        return restTemplate.postForObject(url, entity, IntegrationResponseDTO.class);
    }
//    public String integration(String expression){
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        OperationRequest opRequest = new OperationRequest(expression);
//
//        HttpEntity<OperationRequest> request = new HttpEntity<>(opRequest, headers);
//
//        ResponseEntity<OperationResponse> response = restTemplate.exchange(
//                (this.microserviceUrl + "/api/integration"),
//                HttpMethod.POST,
//                request,
//                OperationResponse.class
//        );
//
//        return response.getBody().result();
//    }
}
