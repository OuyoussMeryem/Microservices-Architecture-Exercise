package ma.ensa.billing_service.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user")
@Getter
@Setter
public class VaultConfig {

    private String username;
    private String password;
    private String otp;
}
