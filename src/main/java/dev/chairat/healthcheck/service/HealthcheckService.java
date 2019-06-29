package dev.chairat.healthcheck.service;

import dev.chairat.healthcheck.repository.HealthcheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
public class HealthcheckService {

    @Autowired
    private HealthcheckRepository healthcheckRepository;

    public boolean check(String url) {
        HttpStatus responseStatus;
        try {
            responseStatus = healthcheckRepository.getHealthcheckResponseStatus(url);
        } catch (RestClientException restClientException) {
            return false;
        }
        return responseStatus == HttpStatus.OK;
    }

}
