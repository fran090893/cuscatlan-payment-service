package com.cuscatlan.paymentservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "userintegration")
public class UserIntegrationConfig {
    private String secret;
    private String loginUrl;
    private String userUrl;

    // Getters y Setters
    public String getLoginUrl() {
        return loginUrl;
    }

    public String getSecret() {
        return secret;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }
}
