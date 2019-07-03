package dev.chairat.healthcheck.config;

import dev.chairat.healthcheck.model.ErrorGeneral;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.ArrayList;
import java.util.List;

@Data
@ConfigurationProperties
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class HealthcheckConfig {

    @NestedConfigurationProperty
    private String title;

    @NestedConfigurationProperty
    private String url;

    @NestedConfigurationProperty
    private String job_frequency;

    @NestedConfigurationProperty
    private String alert_frequency;

    @NestedConfigurationProperty
    @Builder.Default
    private List<CheckConfig> checks = new ArrayList<>();

    private Boolean result;

    @Builder.Default
    private List<ErrorGeneral> errors = new ArrayList<>();

}
