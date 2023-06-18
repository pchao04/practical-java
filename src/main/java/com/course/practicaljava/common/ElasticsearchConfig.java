package com.course.practicaljava.common;


import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@EnableConfigurationProperties(ElasticsearchProperties.class)
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {
    private static final Integer DEFAULT_KEEP_ALIVE_TIME = 1000 * 60 * 3;

    final ElasticsearchProperties elasticsearchProperties;

    public ElasticsearchConfig(ElasticsearchProperties elasticsearchProperties) {
        this.elasticsearchProperties = elasticsearchProperties;
    }

    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {
        return RestClients.create(clientConfiguration()).rest();
    }


    ClientConfiguration clientConfiguration() {
        var configBuilder = ClientConfiguration.builder()
                .connectedTo(getConnectUris());

        if (getUsingSsl()) {
            configBuilder.usingSsl();
        }

        configBuilder
                //.withBasicAuth(elasticsearchProperties.getUsername(), elasticsearchProperties.getPassword())
                .withHttpClientConfigurer(configure ->
                        configure.setKeepAliveStrategy((httpResponse, httpContext) -> DEFAULT_KEEP_ALIVE_TIME));

        return configBuilder.build();
    }
    private Boolean isUriUsingSsl(String uriStr) {
        return uriStr.startsWith("https");
    }

    private String parseHostAndPort(String uriStr) {
        try {
            var uri = new URI(uriStr);
            var port = uri.getPort();
            if (port == -1) {
                port = isUriUsingSsl(uriStr) ? 443 : 80;
            }
            return String.format("%s:%s", uri.getHost(), port);

        } catch (URISyntaxException e) {
            throw new RuntimeException("parsing elasticsearch uri error", e);
        }
    }
    private Boolean getUsingSsl() {
        return elasticsearchProperties.getUris().stream()
                .anyMatch(this::isUriUsingSsl);
    }

    private String[] getConnectUris() {
        return elasticsearchProperties.getUris().stream()
                .map(this::parseHostAndPort)
                .toArray(String[]::new);
    }
}
