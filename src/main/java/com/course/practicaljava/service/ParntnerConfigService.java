package com.course.practicaljava.service;


import com.course.practicaljava.entity.PartnerConfig;
import lombok.extern.slf4j.Slf4j;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.*;

@Service
@Slf4j
public class ParntnerConfigService {
    private static final String EDI_PARTNER_CONFIGS = "edi_partner_configs";


    @Autowired
    private ElasticsearchOperations elasticsearch;

    private final RestHighLevelClient elasticsearchClient;

    public ParntnerConfigService(RestHighLevelClient elasticsearchClient) {

        this.elasticsearchClient = elasticsearchClient;
    }
    public List<SearchHit<PartnerConfig> > findAll() {
        Query searchQuery = new StringQuery(
                "{\"match_all\":{}}\"");

        SearchHits<PartnerConfig> products = elasticsearch.search(searchQuery, PartnerConfig.class,
                IndexCoordinates.of(EDI_PARTNER_CONFIGS));

        return products.getSearchHits();
    }

    public List<Object > getCustomers3() {
        var query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("_id", "SLHF_315"))
                .build();

        SearchHits<PartnerConfig> searchHits = elasticsearch.search(query, PartnerConfig.class,
                IndexCoordinates.of(EDI_PARTNER_CONFIGS));


        for (SearchHit hit : searchHits) {
            // no _source ....
            log.info("hit={}", hit);
        }

        var data = searchHits.getSearchHits()
                .stream()
                .map(x->x.getContent().getSource())
                .distinct().collect(Collectors.toList());

        return data;
    }


    public List<Object > getCustomers2() {
        Query searchQuery = new StringQuery(
                "{\"match_all\":{}}\"");

        SearchHits<PartnerConfig> searchHits = elasticsearch.search(searchQuery, PartnerConfig.class,
                IndexCoordinates.of(EDI_PARTNER_CONFIGS));
        log.info(searchHits.getSearchHits().toString());
        var searchSourceBuilder = new SearchSourceBuilder()
                .query(QueryBuilders.matchAllQuery())
                .fetchSource(new String[] {
                        "partner"
                }, null);

        searchSourceBuilder.query();

        for (SearchHit hit : searchHits) {
            // do something with the SearchHit
            //hit.getSourceAsMap();
           // log.info(hit);

        }

        var data = searchHits.getSearchHits()
                .stream()
                .map(x->x.getContent().getSource())
                .distinct().collect(Collectors.toList());

        return data;
    }

    public List<Object > getCustomers() {
//        var id = "SLHF_315";
//        GetRequest getRequest = new GetRequest(PRODUCT_INDEX, id);
//        GetResponse getResponse = null;
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();

        var opts = builder.build();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();  // 默认配置
        //sourceBuilder.index(PRODUCT_INDEX);
        sourceBuilder.query(QueryBuilders.matchQuery("_id","SLHF_315"));
        SearchRequest searchRequest = new SearchRequest()
                .indices(EDI_PARTNER_CONFIGS)
                .source(sourceBuilder);

        SearchResponse resp;
        //resp = elasticsearchClient.search(searchRequest, opts);

        try {
            //getResponse = elasticsearchClient.get(getRequest, opts);
            //SearchRequest searchRequest = new SearchRequest();
            resp = elasticsearchClient.search(searchRequest, opts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var i =1;
        for (org.elasticsearch.search.SearchHit hit : resp.getHits()) {
            // do something with the SearchHit
            //hit.getSourceAsMap();
            log.info("i={} ", i++);
            var map = hit.getSourceAsMap();

            if (map!= null) {
                //Slog.info(map.toString());
                var val = map.get("partner");
                if (val!=null) {
                    log.info(val.toString());
                }


            }

        }

//        if (getResponse.isExists()) {
//
//            var a = getResponse.getSource();
//            log.info(a.toString());
//        } else {
//            return null; // or handle non-existing document case
//        }

        return null;
    }
}
