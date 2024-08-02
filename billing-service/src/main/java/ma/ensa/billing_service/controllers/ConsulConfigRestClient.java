package ma.ensa.billing_service.controllers;

import ma.ensa.billing_service.config.ConsulConfig;
import ma.ensa.billing_service.config.VaultConfig;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConsulConfigRestClient {

    private ConsulConfig consulConfig;
    private VaultConfig vaultConfig;

    public ConsulConfigRestClient(ConsulConfig consulConfig, VaultConfig vaultConfig) {
        this.consulConfig = consulConfig;
        this.vaultConfig = vaultConfig;
    }

    @GetMapping(path="/ConsulParams")
    public ConsulConfig testConsulConfig(){
        return  consulConfig;
    }

    @GetMapping(path="/vaultParams")
        public VaultConfig testVaultConfig(){
        return vaultConfig;
        }

    @GetMapping(path = "/allParams")
    public Map<String,Object> allParams(){
        return Map.of("consulConfig",consulConfig,"vaultConfig",vaultConfig);
    }



}
