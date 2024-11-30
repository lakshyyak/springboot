package com.lakshyya.multipe_data_source.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "com.lakshyya.multipe_data_source.repo.student",
    entityManagerFactoryRef = "studentEntityManagerFactoryBean",
    transactionManagerRef = "studentTransactionManager"
)
public class StudentDbJpaConfig {

    @Bean
    LocalContainerEntityManagerFactoryBean studentEntityManagerFactoryBean(@Qualifier("studentDataSource") DataSource dataSource){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =  new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.lakshyya.multipe_data_source.entities.student");
        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(adapter);

        Map<String,String> props = new HashMap<>();
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hbm2ddl.auto","update");
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(props);
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    PlatformTransactionManager studentTransactionManager(@Qualifier("studentEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean){
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }

}
