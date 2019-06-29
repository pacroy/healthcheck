package dev.chairat.healthcheck.service;

import org.springframework.stereotype.Service;

@Service
public class HealthcheckService {

    public boolean check(String url) {
        return true;
    }

}
