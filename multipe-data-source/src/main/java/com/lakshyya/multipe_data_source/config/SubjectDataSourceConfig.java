package com.lakshyya.multipe_data_source.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
public class SubjectDataSourceConfig {

    @ConfigurationProperties("subject.spring.datasource")
    @Bean
    DataSourceProperties subjectDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    DataSource subjectDataSource(){
        return subjectDataSourceProperties().initializeDataSourceBuilder().build();
    }

}
