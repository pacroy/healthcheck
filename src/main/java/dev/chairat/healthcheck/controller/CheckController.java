package dev.chairat.healthcheck.controller;

import dev.chairat.healthcheck.config.HealthcheckConfigurationProperties;
import dev.chairat.healthcheck.service.HealthcheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/check")
public class CheckController {

    @Autowired
    private HealthcheckService healthcheckService;

    @Autowired
    private HealthcheckConfigurationProperties healthcheckConfigurationProperties;

    @GetMapping
    public ResponseEntity<HealthcheckConfigurationProperties> check() {
        HealthcheckConfigurationProperties healthcheckConfigurationPropertiesToReturn =
                HealthcheckConfigurationProperties.builder()
                .healthchecks(new ArrayList<>())
                .build();
        healthcheckConfigurationPropertiesToReturn.getHealthchecks().add(
                healthcheckService.check(healthcheckConfigurationProperties.getHealthchecks().get(0)));
        return ResponseEntity.ok(healthcheckConfigurationPropertiesToReturn);
    }

}
