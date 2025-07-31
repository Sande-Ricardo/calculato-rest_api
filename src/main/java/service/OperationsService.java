package service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OperationsService {

    @Value("${flask.microservice.url}")
    private String microserviceUrl;

    private final RestTemplate restTemplate = new RestTemplate();


    public String derivation(String expression){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        HttpEntity<String> request = new HttpEntity<>(expression, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                (this.microserviceUrl + "/derivation"),
                HttpMethod.POST,
                request,
                String.class
        );

        return response.getBody();
    }

    public String integration(String expression){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        HttpEntity<String> request = new HttpEntity<>(expression, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                (this.microserviceUrl + "/integration"),
                HttpMethod.POST,
                request,
                String.class
        );

        return response.getBody();
    }
}
