package dev.chairat.healthcheck.service;

import dev.chairat.healthcheck.config.HealthcheckConfig;
import dev.chairat.healthcheck.model.ErrorGeneral;
import dev.chairat.healthcheck.repository.HealthcheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
public class HealthcheckService {

    @Autowired
    private HealthcheckRepository healthcheckRepository;

    public HealthcheckConfig check(HealthcheckConfig healthcheckConfig) {
        HealthcheckConfig healthcheckConfigToReturn = healthcheckConfig.toBuilder().build();

        HttpStatus responseStatus;
        try {
            responseStatus = healthcheckRepository.getHealthcheckResponseStatus(healthcheckConfig.getUrl());
            healthcheckConfigToReturn.setResult( responseStatus == HttpStatus.OK );
            if ( !healthcheckConfigToReturn.getResult() ) {
                healthcheckConfigToReturn.getErrors().add(ErrorGeneral.builder()
                        .type("status_check_failed")
                        .description("The url does not return status 200 OK")
                        .build());
            }
        } catch (RestClientException restClientException) {
            healthcheckConfigToReturn.setResult(false);
            healthcheckConfigToReturn.getErrors().add(ErrorGeneral.builder()
                    .type(restClientException.getClass().toString())
                    .description(restClientException.getMessage())
                    .build());
        }
        return healthcheckConfigToReturn;
    }

}
