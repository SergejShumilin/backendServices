package org.example.config.custom;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("QA")
public class H2CustomConfig {
    @Bean
    @ConditionalOnMissingBean(DataSource.class)
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("sa")
                .password("")
                .url("jdbc:h2:mem:dcbapp;DB_CLOSE_ON_EXIT=FALSE")
                .driverClassName("org.h2.Driver")
                .build();
    }
}
