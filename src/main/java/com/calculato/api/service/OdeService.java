package com.calculato.api.service;

import com.calculato.api.dto.OdeSlopeFieldRequestDTO;
import com.calculato.api.dto.OdeSlopeFieldResponseDTO;
import com.calculato.api.dto.OdeSolveRequestDTO;
import com.calculato.api.dto.OdeSolveResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class OdeService {

    private final Logger logger = LoggerFactory.getLogger(OdeService.class);

    private final RestTemplate restTemplate;

    @Value("${flask.microservice.url}")
    private String microserviceUrl;

    @Autowired
    public OdeService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public OdeSolveResponseDTO solveOde(OdeSolveRequestDTO req) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<OdeSolveRequestDTO> entity = new HttpEntity<>(req, headers);

        String url = this.microserviceUrl + "/api/flask/ode/solve";
        return restTemplate.postForObject(url, entity, OdeSolveResponseDTO.class);
    }

    public OdeSlopeFieldResponseDTO getSlopeField(OdeSlopeFieldRequestDTO req) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<OdeSlopeFieldRequestDTO> entity = new HttpEntity<>(req, headers);

        String url = this.microserviceUrl + "/api/flask/ode/slope-field";
        return restTemplate.postForObject(url, entity, OdeSlopeFieldResponseDTO.class);
    }
}
