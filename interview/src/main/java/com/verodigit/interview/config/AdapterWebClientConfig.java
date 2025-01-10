package com.verodigit.interview.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * This class configures as a central point the WebClientConfig, any security, credentials, exchangeStrategies and oAuthFilters should be defined here.
 *
 */
@Configuration
public class AdapterWebClientConfig {

    public static final String ADAPTER_WEBCLIENT_BEAN_NAME = "clientName123";

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager() {
        return new DefaultOAuth2AuthorizedClientManager(
                clientRegistrationRepository, (OAuth2AuthorizedClientRepository) authorizedClientService);
    }

    @Bean
    public ServerOAuth2AuthorizedClientExchangeFilterFunction getOAuthFilter() {
        ServerOAuth2AuthorizedClientExchangeFilterFunction oauth2Filter =
                new ServerOAuth2AuthorizedClientExchangeFilterFunction((ReactiveOAuth2AuthorizedClientManager) authorizedClientManager());
        oauth2Filter.setDefaultOAuth2AuthorizedClient(true);
        return oauth2Filter;
    }

    @Bean(ADAPTER_WEBCLIENT_BEAN_NAME)
    public WebClient getAdapterWebClient() {
                return WebClient.builder()
                .baseUrl("http://localhost:8080")
                .defaultHeader("Content-Type", "application/json")
                .filter(getOAuthFilter())
                .build();
    }


}