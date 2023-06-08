package com.course.practicaljava.common;

import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.erhlc.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.client.erhlc.RestClients;

public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    @Override
    public org.elasticsearch.client.RestHighLevelClient elasticsearchClient() {
        final var clientConfiguration = ClientConfiguration.builder().connectedTo("localhost:9200").build();

        return RestClients.create(clientConfiguration).rest();
    }
}
