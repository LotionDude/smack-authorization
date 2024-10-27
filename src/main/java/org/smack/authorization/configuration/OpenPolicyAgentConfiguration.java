package org.smack.authorization.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("opa-server")
public class OpenPolicyAgentConfiguration {
    private String baseUrl;
}
