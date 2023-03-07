package org.example.config.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("QA")
public class H2CustomConfig {

    @Autowired
    private transient DataSourceProperties dataSourceProperties;
    @Bean
    @ConditionalOnMissingBean(DataSource.class)
    public DataSource dataSource() {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
}
