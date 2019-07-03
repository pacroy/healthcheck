package dev.chairat.healthcheck.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@ConfigurationProperties
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CheckConfig {

    @NestedConfigurationProperty
    private String path;

    @NestedConfigurationProperty
    private String value;

    private Boolean result;

}
