package com.deepak;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.logging.Logger;

/**
 * Created by deepakvalechha on 11/06/18.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.deepak.spring.data.es.repository")
@ComponentScan(basePackages = {"com.deepak.spring.data.es.service"})
public class Config {

    @Bean
    public NodeBuilder nodeBuilder() {
        return new NodeBuilder();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        Settings.Builder elasticsearchSettings =
                Settings.settingsBuilder()
                        .put("http.enabled", "false") // 1
                        .put("path.data", tmpDir.toAbsolutePath().toString()) // 2
                        .put("path.home", "PATH_TO_YOUR_ELASTICSEARCH_DIRECTORY"); // 3

        logger.debug(tmpDir.toAbsolutePath().toString());

        return new ElasticsearchTemplate(nodeBuilder()
                .local(true)
                .settings(elasticsearchSettings.build())
                .node()
                .client());
    }
}
