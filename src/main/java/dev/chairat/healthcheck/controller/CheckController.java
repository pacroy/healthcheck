package dev.chairat.healthcheck.controller;

import dev.chairat.healthcheck.config.HealthcheckConfigurationProperties;
import dev.chairat.healthcheck.model.HealthcheckResult;
import dev.chairat.healthcheck.service.HealthcheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/check")
public class CheckController {

    @Autowired
    private HealthcheckService healthcheckService;

    @Autowired
    private HealthcheckConfigurationProperties healthcheckConfigProperties;

    @GetMapping
    public ResponseEntity<HealthcheckResult> check() {
        String url = "http://localhost:8080/v2/actuator/health";
        return ResponseEntity.ok( HealthcheckResult.builder()
                .id("test")
                .url(url)
                .result(healthcheckService.check(url))
                .message("Title: " + healthcheckConfigProperties.getHealthchecks().get(0).getTitle())
                .build());
    }

}
