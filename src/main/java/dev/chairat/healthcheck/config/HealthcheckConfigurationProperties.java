package dev.chairat.healthcheck.config;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Data
@Builder
public class HealthcheckConfigurationProperties {

    @Builder.Default
    private List<HealthcheckConfig> healthchecks;

}
