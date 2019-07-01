package dev.chairat.healthcheck.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HealthcheckResult {

    private String id;
    private String url;
    private boolean result;
    private String message;

}
