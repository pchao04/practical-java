package com.course.practicaljava.service;

import com.course.practicaljava.entity.PartnerConfig;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;

import java.util.List;

public class B2BMgmService {
    private static final String PRODUCT_INDEX = "edi_partner_configs";
    private ElasticsearchOperations elasticsearchOperations;

    public List<SearchHit<PartnerConfig>> findAll() {
        Query searchQuery = new StringQuery(
                "{\"match_all\":{}}\"");

        SearchHits<PartnerConfig> products = elasticsearchOperations.search(searchQuery, PartnerConfig.class,
                IndexCoordinates.of(PRODUCT_INDEX));

        return products.getSearchHits();
    }
}
