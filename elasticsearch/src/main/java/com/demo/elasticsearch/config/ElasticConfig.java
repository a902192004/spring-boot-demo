package com.demo.elasticsearch.config;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Configuration
@EnableElasticsearchRepositories(basePackages = "com.demo.elasticsearch.repository")
public class ElasticConfig  {

//    private List<String> uris = new ArrayList<>(Collections.singletonList("https://localhost:9200"));
//
//    private String username;
//
//    private String password;
//
//
//    @Override
//    @NonNull
//    public ClientConfiguration clientConfiguration() {
//        return ClientConfiguration.builder()
//                .connectedTo("localhost:9200").build();
//    }

}
