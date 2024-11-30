package com.lakshyya.multipe_data_source.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
public class StudentDataSourceConfig {

    @ConfigurationProperties("student.spring.datasource")
    @Bean
    DataSourceProperties studentDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    DataSource studentDataSource() throws SQLException{
        // System.err.println(studentDataSourceProperties().initializeDataSourceBuilder().build().getConnection().getMetaData().getUserName());
        return studentDataSourceProperties().initializeDataSourceBuilder().build();
    }

}
