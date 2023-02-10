package com.example.vaultcloud.config;

import com.example.vaultcloud.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.vault.annotation.VaultPropertySource;
import org.springframework.vault.annotation.VaultPropertySource.Renewal;

@Configuration
@VaultPropertySource(value = "rotate/test", renewal = Renewal.ROTATE)
public class YAConfig {

    @Autowired
    private Environment env;

    @Bean
    public TestService testService() {
         return new TestService(env.getProperty("userName"), env.getProperty("password"));
    }
}