package com.calculato.api.service;

import com.calculato.api.dto.DescriptiveStatsRequestDTO;
import com.calculato.api.dto.DescriptiveStatsResponseDTO;
import com.calculato.api.dto.ProbabilityStatsRequestDTO;
import com.calculato.api.dto.ProbabilityStatsResponseDTO;
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
public class StatsService {

    private final Logger logger = LoggerFactory.getLogger(StatsService.class);

    private final RestTemplate restTemplate;

    @Value("${flask.microservice.url}")
    private String microserviceUrl;

    @Autowired
    public StatsService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public DescriptiveStatsResponseDTO getDescriptiveStats(DescriptiveStatsRequestDTO req) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<DescriptiveStatsRequestDTO> entity = new HttpEntity<>(req, headers);

        String url = this.microserviceUrl + "/api/stats/descriptive";
        return restTemplate.postForObject(url, entity, DescriptiveStatsResponseDTO.class);
    }

    public ProbabilityStatsResponseDTO getProbabilityStats(ProbabilityStatsRequestDTO req) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<ProbabilityStatsRequestDTO> entity = new HttpEntity<>(req, headers);

        String url = this.microserviceUrl + "/api/stats/probability";
        return restTemplate.postForObject(url, entity, ProbabilityStatsResponseDTO.class);
    }
}
